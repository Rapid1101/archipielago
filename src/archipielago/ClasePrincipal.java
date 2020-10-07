package archipielago;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import archipielago.dto.Archipielago;
import archipielago.dto.CasoPrueba;
import archipielago.dto.Isla;
import archipielago.dto.Segmento;

public class ClasePrincipal {

	private static int numberOfTests;
	private static List<CasoPrueba> casosPrueba = new ArrayList<>();
	private static List<Archipielago> archipielagos = new ArrayList<>();

	public static void main(String[] args) {

		try {
			initData();
		} catch (IOException e) {
			System.out.println("Error al intentar leer el archivo de test");
		}

		casosPrueba.stream().forEach((c) -> {
			generarSegmentos(c);
			agruparSegmentos(c);
			generarArchipielagos(c);
			System.out.println(c.archipielagosValidos());
		});

	}

	private static void initData() throws IOException {
		File file = new File("../ArchipielagoTestcase.txt");
		List<String> fileLines = new ArrayList<>();
		String[] linea;
		int coordenadaX;
		int coordenaday;
		CasoPrueba cp = new CasoPrueba();

		// Leeer archivo
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null) {
			fileLines.add(st);
		}
		br.close();
		numberOfTests = Integer.valueOf(fileLines.get(0));
		fileLines.add("x");

		for (int i = 2; i < fileLines.size(); i++) {
			linea = fileLines.get(i).split(" ");
			if (linea.length == 1) {
				casosPrueba.add(cp);
				cp = new CasoPrueba();
			} else {
				coordenadaX = Integer.valueOf(linea[0]);
				coordenaday = Integer.valueOf(linea[1]);
				cp.getIslas().add(new Isla(coordenadaX, coordenaday));
			}

		}

	}

	private static void generarSegmentos(CasoPrueba caso) {
		int inicio = caso.getIslas().size();
		Isla combinacion[] = new Isla[2];
		generarCombinacion(caso, combinacion, 0, inicio - 1, 0);

	}

	static void generarCombinacion(CasoPrueba caso, Isla combinacion[], int inicio, int fin, int index) {
		if (index == 2) {
			caso.getSegmento().add(new Segmento(combinacion[0], combinacion[1]));
			return;
		}

		for (int i = inicio; i <= fin && fin - i + 1 >= 2 - index; i++) {
			combinacion[index] = caso.getIslas().get(i);
			generarCombinacion(caso, combinacion, i + 1, fin, index + 1);
		}
	}

	private static void agruparSegmentos(CasoPrueba caso) {
		caso.setSegmentosAgrupadosPorLongitud(
				caso.getSegmento().stream().collect(Collectors.groupingBy(Segmento::getLongitud)));

	}

	private static void generarArchipielagos(CasoPrueba caso) {
		Segmento combinacion[] = new Segmento[2];
		caso.getSegmentosAgrupadosPorLongitud().forEach((k, v) -> {
			List<Archipielago> archipielagoPorLongitud = new ArrayList<>();

			generarCombinacionLineas(v, combinacion, 0, v.size() - 1, 0);

			archipielagoPorLongitud.addAll(archipielagos);
			caso.getArchipielagosAgrupadosPorLongitud().put(k, archipielagoPorLongitud);
			archipielagos.clear();

		});

	}

	static void generarCombinacionLineas(List<Segmento> listaSegmentos, Segmento combinacionSegmentos[], int inicio,
			int fin, int index) {
		if (index == 2) {
			archipielagos.add(new Archipielago(combinacionSegmentos[0], combinacionSegmentos[1]));
			return;
		}

		for (int i = inicio; i <= fin && fin - i + 1 >= 2 - index; i++) {
			combinacionSegmentos[index] = listaSegmentos.get(i);
			generarCombinacionLineas(listaSegmentos, combinacionSegmentos, i + 1, fin, index + 1);
		}
	}

}
