package com.intercorp.clientes.core.base.utils;

import java.util.List;

import com.intercorp.clientes.core.dto.ClienteDto;

/**
 * Clase utilitaria
 * 
 * @author dwilsonc
 *
 */
public class Utils {

	/**
	 * Metodo que obtiene la media
	 * 
	 * @param listaClientesDto
	 * @return
	 */
	public static double calcularMedia(List<ClienteDto> listaClientesDto) {
		int totalEdades = 0;
		double media;
		for (ClienteDto clienteDto : listaClientesDto) {
			totalEdades = totalEdades + clienteDto.getEdad().intValue();
		}

		media = (double) totalEdades / listaClientesDto.size();

		return Math.rint(media*100)/100;
	}

	/**
	 * Metodo que obtiene la varianza
	 * 
	 * @param listaClientesDto
	 * @param media
	 * @return
	 */
	public static double calcularVarianza(List<ClienteDto> listaClientesDto, double media) {
		double sumatoria;
		double varianza = 0;

		for (ClienteDto clienteDto : listaClientesDto) {
			sumatoria = Math.pow(clienteDto.getEdad() - media, 2);
			varianza = varianza + sumatoria;
		}

		varianza = varianza / listaClientesDto.size();

		return Math.rint(varianza*100)/100;
	}
	
	/**
	 * Metodo que obtiene la desviacion estandar
	 * 
	 * @param listaClientesDto
	 * @param media
	 * @return
	 */
	public static double calcularDesviacionEstandar(List<ClienteDto> listaClientesDto, double media) {
		double desviacionEstandar = 0;
		double varianza = calcularVarianza(listaClientesDto, media);
		
		desviacionEstandar = Math.sqrt(varianza);
		double redondeo = Math.rint(desviacionEstandar*100)/100;
		
		return redondeo;
	}

}
