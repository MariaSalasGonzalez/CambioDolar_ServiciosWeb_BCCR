/*
 * Universidad Nacional de Costa Rica 
 * Escuela de Informatica
 * Programacion IV 
 * Laboratorio #4
 * Profesor: Dario Rios
 * Estudiante: Maria Salas Gonzalez
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package lab4_mariasalas;
import com.progra.ws.Lab4_MariaSalas.Wsindicadoreseconomicos;
 //librerias para usar DOM 
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author MariaSalas
 */

public class Lab4_MariaSalas {
    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     */
    public static void main(String[] args) throws Exception{
        
        //*** Codigo para Serializar ***
       System.out.println(" ------------------------------- ");
       System.out.println("|           D A T O S           |");
       System.out.println("|     S E R I A L I Z A D O S   |");
       System.out.println(" ------------------------------- ");
       System.out.println("");
       Wsindicadoreseconomicos cliente = new Wsindicadoreseconomicos();
       //Tipo de Compra
       String tipoCambioCompra = cliente.getWsindicadoreseconomicosSoap()
               .obtenerIndicadoresEconomicosXML("317", "26/10/2021", "26/10/2021", "Maria Salas", "N", "maria.salas.gonzalez@est.una.ac.cr", "AAA20GMNT8");
      
       //Tipo de Venta
       String tipoCambioVenta = cliente.getWsindicadoreseconomicosSoap()
               .obtenerIndicadoresEconomicosXML("318", "26/10/2021", "26/10/2021", "Maria Salas", "N", "maria.salas.gonzalez@est.una.ac.cr", "AAA20GMNT8");
       System.out.println("Tipo de Compra: " + tipoCambioCompra); System.out.println("");
       System.out.println("Tipo de Venta: " + tipoCambioVenta); System.out.println("");
       
       //*** Codigo para Deserializar *** 
        System.out.println(" ------------------------------- ");
        System.out.println("|           D A T O S           |");
        System.out.println("|  D E S E R I A L I Z A D O S  |");
        System.out.println(" ------------------------------- "); System.out.println("");
        
        //Tipo de Compra
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource inputS = new InputSource();
        inputS.setCharacterStream(new StringReader(tipoCambioCompra));
        Document docu = builder.parse(inputS);
        NodeList nodo = docu.getElementsByTagName("INGC011_CAT_INDICADORECONOMIC"); 
        
        for (int j=0; j<nodo.getLength(); j++) {    
            Element ele = (Element) nodo.item(j);
            //Nodo Num Valor
            NodeList valor = ele.getElementsByTagName("NUM_VALOR");
            Element li = (Element) valor.item(0);
            
            //Nodo Fecha
            NodeList fecha = ele.getElementsByTagName("DES_FECHA");
            Element li2 = (Element) fecha.item(0);
            System.out.println("Tipo de Compra" + "(" + getCharacterDataFromElement(li2) + "): " + getCharacterDataFromElement(li));
            System.out.println("");
        }//fin del for
        
        //Tipo de Venta
        DocumentBuilder builder2 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource inputS2 = new InputSource();
        inputS2.setCharacterStream(new StringReader(tipoCambioVenta));
        Document docu2 = builder2.parse(inputS2);
        NodeList nodo2 = docu2.getElementsByTagName("INGC011_CAT_INDICADORECONOMIC");
        
        for (int j=0; j<nodo.getLength(); j++) {    
            Element ele2 = (Element) nodo2.item(j);
            //Nodo Num Valor
            NodeList valor = ele2.getElementsByTagName("NUM_VALOR");
            Element line = (Element) valor.item(0);
            
            //Nodo Fecha
            NodeList fecha = ele2.getElementsByTagName("DES_FECHA");
            Element li2 = (Element) fecha.item(0);
            System.out.println("Tipo de Venta" + "(" + getCharacterDataFromElement(li2) + "): " + getCharacterDataFromElement(line));
            System.out.println("");
        }//fin del for
  }//fin del main

  //Metodo para sacarlo nodo por nodo
  public static String getCharacterDataFromElement(Element e) {
    Node child = e.getFirstChild();
    if (child instanceof CharacterData) {
      CharacterData cd = (CharacterData) child;
      return cd.getData();
    }//fin de if
    return "";
  }//fin de metodo
}//fin de clase

//NOTAS: 
//Codigo base usado para deserializar los datos: http://www.java2s.com/Code/Java/XML/ParseanXMLstringUsingDOMandaStringReader.htm
