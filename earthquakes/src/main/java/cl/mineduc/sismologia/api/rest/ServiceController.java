package cl.mineduc.sismologia.api.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cl.mineduc.sismologia.models.entity.Metadata;
import cl.mineduc.sismologia.models.entity.Periodo;
import cl.mineduc.sismologia.models.entity.Rango;
import cl.mineduc.sismologia.service.impl.IMetadataService;
import cl.mineduc.sismologia.tools.Tools;
import io.swagger.annotations.Api;
import okhttp3.Response;


/**
 * 
 * Contenedor de Servicio: EarthQuakes 
 * 
 * 
 * 1.- Servicio earthquakes Filtro Desde Hasta 
 * 2.- Servicio earthquakes Filtro minMagnitud maxMagnitud
 * 
 * 
 * @author Alejandro Sandoval S.
 * @since 1.0
 */


@CrossOrigin(origins = { "*" })
@RestController
@Component
@Api(tags = "EARTHQUAKES SERVICE", description = "Servicio recopilación de Datos Sismográficos")
@RequestMapping("/api")
public class ServiceController  {

	Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private IMetadataService metadataService;
	
    @Value("${url.heartquake.endpoint}")
    private String url;
	
	@RequestMapping(value = "/date/earthquakes", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> earthquakes(@Valid @RequestBody Periodo periodo, BindingResult result) throws IOException {

		Map<String, Object> response = new HashMap<>();
		String ret = "";

		logger.info("### earthquakes Init");

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			Response resp = Tools.getInstance().responseOkHttp(url + "query?format=geojson&starttime="
					+ periodo.getStarttime() + "&endtime=" + periodo.getEndtime());
			String json = resp.body().string();
			JSONObject sismo = new JSONObject(json);
			JSONObject md_object = sismo.getJSONObject("metadata");
			ObjectMapper mapper = new ObjectMapper();
			Metadata meta = mapper.readValue(md_object.toString(), Metadata.class);
			metadataService.save(meta);
			ret = json;
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La Bitácora  ha sido creado con éxito!");
		response.put("bitacora", ret);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	} 
	
	
	@RequestMapping(value = "/magnitude/earthquakes", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> magnitude(@Valid @RequestBody Rango rango, BindingResult result) throws IOException {

		Map<String, Object> response = new HashMap<>();
		String ret = "";

		logger.info("### earthquakes Init");

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			Response resok = Tools.getInstance().responseOkHttp(url + "query?format=geojson&minmagnitude="+rango.getMinmagnitude()+"&maxmagnitude="+rango.getMaxmagnitude());
			String json = resok.body().string();
			JSONObject sismo = new JSONObject(json);
			JSONObject md_object = sismo.getJSONObject("metadata");
			ObjectMapper mapper = new ObjectMapper();
			Metadata meta = mapper.readValue(md_object.toString(), Metadata.class);
			metadataService.save(meta);
			ret = json;
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La Bitácora  ha sido creado con éxito!");
		response.put("bitacora", ret);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}  	
	
	
}

