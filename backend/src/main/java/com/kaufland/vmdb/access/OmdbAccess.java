package com.kaufland.vmdb.access;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OmdbAccess {

    public static JSONObject queryMovieByTitle(String title) {
        String url = "https://www.omdbapi.com/?apikey=53f133e4&t=";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url + title.replaceAll("\\s", "+").replaceAll("'", "%27")).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String json = reader.lines().collect(Collectors.joining());
            return new JSONObject(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject queryMovieById(String id) {
        String url = "https://www.omdbapi.com/?apikey=53f133e4&i=";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url + id).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String json = reader.lines().collect(Collectors.joining());
            return new JSONObject(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> movieIds = Arrays.asList("tt0111161", "tt0068646", "tt0071562", "tt0468569", "tt0050083",
            "tt0108052", "tt0167260", "tt0110912", "tt0060196", "tt0137523", "tt0120737", "tt0109830", "tt0080684",
            "tt1375666", "tt0167261", "tt0073486", "tt0099685", "tt0133093", "tt0047478", "tt0317248", "tt0076759",
            "tt0114369", "tt0102926", "tt0038650", "tt0118799", "tt0114814", "tt0245429", "tt0120815", "tt0110413",
            "tt0120689", "tt0816692", "tt4154756", "tt0120586", "tt0054215", "tt0021749", "tt0064116", "tt0034583",
            "tt0027977", "tt1675434", "tt0253474", "tt0407887", "tt0103064", "tt0088763", "tt0047396", "tt0082971",
            "tt2582802", "tt0172495", "tt0110357", "tt0482571", "tt0209144", "tt0078788", "tt0078748", "tt0032553",
            "tt0095765", "tt0095327", "tt0043014", "tt0057012", "tt0405094", "tt0050825", "tt0081505", "tt1853728",
            "tt0910970", "tt2380307", "tt0119698", "tt0051201", "tt0169547", "tt1345836", "tt0364569", "tt0090605",
            "tt0087843", "tt0082096", "tt0033467", "tt0052357", "tt0112573", "tt0053125", "tt0105236", "tt5311514",
            "tt0086190", "tt0022100", "tt5074352", "tt0180093", "tt0086879", "tt0986264", "tt0056172", "tt0066921",
            "tt0211915", "tt0338013", "tt0036775", "tt0075314", "tt1187043", "tt0062622", "tt0114709", "tt0045152",
            "tt0093058", "tt0361748", "tt0056592", "tt0040522", "tt0012349", "tt0070735", "tt0435761", "tt0119217",
            "tt2106476", "tt0208092", "tt0071853", "tt0059578", "tt0086250", "tt0119488", "tt0053604", "tt0017136",
            "tt1832382", "tt0097576", "tt0042876", "tt1049413", "tt0055630", "tt0042192", "tt0372784", "tt0053291",
            "tt0105695", "tt0363163", "tt0040897", "tt0095016", "tt0113277", "tt0081398", "tt0044741", "tt0476735",
            "tt0057115", "tt1255953", "tt0118849", "tt0041959", "tt0457430", "tt0071315", "tt0096283", "tt0089881",
            "tt0055031", "tt0347149", "tt0015864", "tt1305806", "tt5027774", "tt0050212", "tt0047296", "tt0268978",
            "tt0120735", "tt0050976", "tt0112641", "tt2096673", "tt3170832", "tt0080678", "tt0031679", "tt0993846",
            "tt0434409", "tt1291584", "tt0083658", "tt0050986", "tt0017925", "tt0046912", "tt0117951", "tt0477348",
            "tt0031381", "tt0167404", "tt0469494", "tt0116282", "tt1205489", "tt0084787", "tt0077416", "tt0266543",
            "tt0015324", "tt0091251", "tt0118715", "tt0266697", "tt0061512", "tt1130884", "tt0032976", "tt0046438",
            "tt0018455", "tt2119532", "tt0978762", "tt0892769", "tt2267998", "tt3011894", "tt0758758", "tt0116231",
            "tt0079470", "tt0107290", "tt0025316", "tt0091763", "tt0107207", "tt2278388", "tt0092005", "tt0060107",
            "tt0074958", "tt4912910", "tt0405508", "tt0395169", "tt0120382", "tt0079944", "tt0060827", "tt0052618",
            "tt0019254", "tt0046268", "tt0353969", "tt2024544", "tt1979320", "tt0405159", "tt1392190", "tt0053198",
            "tt0112471", "tt1895587", "tt3315342", "tt0245712", "tt1028532", "tt1392214", "tt0093779", "tt0087544",
            "tt0064115", "tt0264464", "tt1201607", "tt0075148", "tt0033870", "tt0072684", "tt1856101", "tt0198781",
            "tt0032551", "tt3783958", "tt0246578", "tt0046911", "tt0050783", "tt0083987", "tt0088247", "tt0097165",
            "tt0113247", "tt1280558", "tt0107048", "tt0032138", "tt0070510", "tt0073195", "tt1954470", "tt1454029",
            "tt0118694", "tt0052311", "tt0440963", "tt0381681", "tt0056801", "tt2015381", "tt0087884", "tt2991224",
            "tt4016934", "tt0036868", "tt3606756", "tt0101414", "tt0325980");
}
