package com.intercorp.clientes.ws.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.intercorp.clientes.core.dto.ClienteDto;

public class UtilService {

	ClassLoader classLoader = getClass().getClassLoader();
	Gson gson = new Gson();

	@SuppressWarnings("serial")
	public List<ClienteDto> getLoadJsonClientes(String pathJson) throws IOException {
		List<ClienteDto> clientesList;
		File file = new File(classLoader.getResource(pathJson).getFile());
		String content = new String(Files.readAllBytes(file.toPath()));
		clientesList = gson.fromJson(content, new TypeToken<List<ClienteDto>>() {
		}.getType());
		return clientesList;
	}
}
