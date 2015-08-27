package knf.animeflv;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jordy on 10/08/2015.
 */
public class Parser {

    public String[] parseLinks(String json){
        List<String> linkArray=new ArrayList<String>();
        String[] urls;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("lista");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String link = "http://cdn.animeflv.net/img/portada/thumb_80/"+childJSONObject.getString("aid")+".jpg";
                linkArray.add(link);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            urls = new String[linkArray.size()];
            linkArray.toArray(urls);
        }
        return urls;
    }

    public String getUrlPortada(String json){
        String url="";
        try {
            JSONObject jsonObj = new JSONObject(json);
            url = "http://cdn.animeflv.net/img/portada/"+jsonObj.getString("aid")+".jpg";

        }catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
    public String getInfoSinopsis(String json){
        String url="";
        try {
            JSONObject jsonObj = new JSONObject(json);
            url = jsonObj.getString("sinopsis");
            url=url.replace("&aacute;", "\u00E1");
            url=url.replace("&eacute;","\u00E9");
            url=url.replace("&iacute;","\u00ED");
            url=url.replace("&oacute;","\u00F3");
            url=url.replace("&uacute;","\u00FA");
            url=url.replace("&Aacute;","\u00C1");
            url=url.replace("&Eacute;","\u00C9");
            url=url.replace("&Iacute;","\u00CD");
            url=url.replace("&Oacute;","\u00D3");
            url=url.replace("&Uacute;","\u00DA");
            url=url.replace("&ntilde;","\u00F1");
            url=url.replace("&ldquo;","\u201C");
            url=url.replace("&rdquo;","\u201D");
            url=url.replace("&rsquo;","\u2019");
            url=url.replace("&iquest;","\u00BF");
            url=url.replace("&hellip;","\u2026");
            url=url.replace("&#333;","\u014D");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public String getInfotitulo(String json){
        String url="";
        try {
            JSONObject jsonObj = new JSONObject(json);
            url = jsonObj.getString("titulo");
            url=url.replace("&#039;","!");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
    public String getInfoTipo(String json){
        String url="";
        try {
            JSONObject jsonObj = new JSONObject(json);
            url = jsonObj.getString("tid");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
    public String getInfoEstado(String json){
        String url="";
        try {
            JSONObject jsonObj = new JSONObject(json);
            url = jsonObj.getString("fecha_fin");
            if (url.trim().equals("0000-00-00")){
                url="En emision";
            }else {
                url="Terminado";
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
    public String getInfoGeneros(String json){
        String url="";
        try {
            JSONObject jsonObj = new JSONObject(json);
            url = jsonObj.getString("generos");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public String[] parseTitulos(String json){
        List<String> titulosArray=new ArrayList<String>();
        String[] titulos;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("lista");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String titulo = childJSONObject.getString("titulo");
                titulosArray.add(titulo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            titulos = new String[titulosArray.size()];
            titulosArray.toArray(titulos);
        }
        return titulos;
    }

    public String[] parseCapitulos(String json){
        List<String> capitulosArray=new ArrayList<String>();
        String[] capitulos;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("lista");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String tid = childJSONObject.getString("tid");
                String numero = childJSONObject.getString("numero");
                if ("Anime".equals(tid)){
                    capitulosArray.add("Capitulo "+numero);
                }else if ("OVA".equals(tid)){
                    capitulosArray.add("OVA "+numero);
                }else {
                    capitulosArray.add("Pelicula");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            capitulos = new String[capitulosArray.size()];
            capitulosArray.toArray(capitulos);
        }
        return capitulos;
    }

    public String[] parsenumeros(String json){
        List<String> numerosArray=new ArrayList<String>();
        String[] numeros;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("lista");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String numero = childJSONObject.getString("numero");
                numerosArray.add(numero);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            numeros = new String[numerosArray.size()];
            numerosArray.toArray(numeros);
        }
        return numeros;
    }

    public String[] parseEID(String json){
        List<String> eidsArray=new ArrayList<String>();
        String[] eids;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("lista");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String eid = childJSONObject.getString("eid");
                eidsArray.add(eid);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            eids = new String[eidsArray.size()];
            eidsArray.toArray(eids);
        }
        return eids;
    }
    public List<String> parseNumerobyEID(String json){
        List<String> eidsArray=new ArrayList<String>();
        String[] eids;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("episodios");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String eid = childJSONObject.getString("num");
                eidsArray.add("Capitulo "+eid);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return eidsArray;
    }
    public List<String> parseTitRel(String json){
        List<String> eidsArray=new ArrayList<String>();
        String[] eids;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("relacionados");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String tituloRel = childJSONObject.getString("titulo");
                tituloRel=tituloRel.replace("&#039;","!");
                eidsArray.add(tituloRel);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return eidsArray;
    }
    public List<String> parseTiposRel(String json){
        List<String> eidsArray=new ArrayList<String>();
        String[] eids;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("relacionados");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String rel_tipo = childJSONObject.getString("rel_tipo");
                String tid = childJSONObject.getString("tid");
                eidsArray.add(rel_tipo+" - "+tid);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return eidsArray;
    }
    public String[] urlsRel(String json){
        List<String> urlArray=new ArrayList<String>();
        String[] urls;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("relacionados");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String url = "http://cdn.animeflv.net/img/portada/thumb_80/"+childJSONObject.getString("aid")+".jpg";
                urlArray.add(url);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            urls = new String[urlArray.size()];
            urlArray.toArray(urls);
        }
        return urls;
    }
    public String[] parseAidRel(String json){
        List<String> urlArray=new ArrayList<String>();
        String[] urls;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("relacionados");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String url = childJSONObject.getString("aid");
                urlArray.add(url);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            urls = new String[urlArray.size()];
            urlArray.toArray(urls);
        }
        return urls;
    }
    public String getAID (String json){
        String aid="";
        try {
            JSONObject jsonObj = new JSONObject(json);
            aid=jsonObj.getString("aid");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return aid;
    }
    public String getTit(String json){
        String aid="";
        try {
            JSONObject jsonObj = new JSONObject(json);
            aid=jsonObj.getString("titulo");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return aid;
    }

    public String[] parseAID(String json){
        List<String> aidsArray=new ArrayList<String>();
        String[] aids;
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("lista");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject childJSONObject = jsonArray.getJSONObject(i);
                String eid = childJSONObject.getString("aid");
                aidsArray.add(eid);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            aids = new String[aidsArray.size()];
            aidsArray.toArray(aids);
        }
        return aids;
    }

    public Boolean igual(String json, String paid){
        String aid="";
        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONArray jsonArray = jsonObj.getJSONArray("lista");
            JSONObject childJSONObject = jsonArray.getJSONObject(0);
            aid = childJSONObject.getString("aid");
                    }catch (Exception e) {
            e.printStackTrace();
        }
        return paid.equals(aid);
    }
}