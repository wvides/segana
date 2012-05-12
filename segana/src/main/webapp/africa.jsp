<%-- 
    Document   : addBet
    Created on : 12-abr-2012, 14:53:48
    Author     : eddytrex
--%>

<%@page import="logic.TorneoEu"%>
<%@page import="segana.Encuentro"%>
<%@page import="java.util.List"%>
<%@page import="logic.TorneoD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Se Gana gambling site</title>
<meta name="keywords" content="platinum, web design theme, free templates, website templates, CSS, HTML" />
<meta name="description" content="Platinum Theme is a free CSS template provided by templatemo.com" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />

<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>
    </head>
    <%
        //String x = request.getParameter("email");
        String username=(String) session.getAttribute("namen");
        
        if(username!=null)
        {
            out.println("<p style=\"text-align:center;\"><a href=\"#\" >"+ username +"</a> , <a href=\"logout.jsp\" >Logout</a></p> ");
            
       }
        if(username==null)
        {
            response.sendRedirect("index.jsp");
        }
    %>
    <body>
       
        <div id="templatemo_wrapper">

            <div id="templatemo_header">
                <div id="site_title"><h1><a href="index.jsp">Se Gana</a></h1></div>
                <div id="templatemo_menu" class="ddsmoothmenu">
                    <ul>
                        <li><a href="index.html" class="selected"><span></span>Home</a></li>
                        <li><a href="about.html"><span></span>Play</a>
                            <ul>
                                <li><a href="submenupage.html">For Virtual Money</a></li>
                                <li><a href="submenupage.html">For Real Money</a></li>                                
                            </ul>
                        </li>                        
                        <li><a href="blog.html"><span></span>Login</a>
                            <ul>
                                    <li><a href="login.jsp">Sign in (Have account)</a></li>
                                    <li><a href="register.jsp">Sign up (Create account)</a></li>                                
                            </ul>
                        </li>
                        <li><a href="portfolio.html"><span></span>About Us</a>
                            <ul>
                                <li><a href="submenupage.html">About "Se Gana"</a></li>
                                <li><a href="submenupage.html">About Developers</a></li>                                
                        </ul>
                        </li>
                        <li><a href="contact.html"><span></span>Contact</a>
                            <ul>
                                    <li><a href="submenupage.html">IRC Channel</a></li>
                                    <li><a href="submenupage.html">Via Email</a></li>                                
                            </ul>
                        </li>
                    </ul>
                    <br style="clear: left" />
                </div> <!-- end of menu -->
            </div> <!-- end of header -->

            <div id="templatemo_middle">                                                            
                    
                    <form name="addc" action="addBet" method="POST">
                        <table border="0">
                           
                            <!--  aqui va la tabla de datos    -->                            

                            <tbody>
                                <tr>
                                   <!-- <td>Numero De Tarjeta</td>
                                    <td><input type="text" name="notarjeta" value="" size="40" /></td>-->
                                </tr>
                                
                                <%
                                
                                    TorneoD nuevo=new TorneoD();
                                    List<Encuentro> nuevaLista;
                                    int i=0;                                                                       
                                %>
                            
                            <%
                                out.println("<br />");                                                                
                                nuevaLista=nuevo.getTorneo("from Encuentro where Escenario like 'Africa'");
                                    i=0;
                                    int cnt = 0;                                    
                                    
                                    while(i<nuevaLista.size())
                                     {
                                        if(cnt == 0){
                                        out.println("<table border=\"4\">");
                                        out.println("<tbody>");
                                        out.println("<tr>");                                            
                                        }                                        
                                        out.println("<td>");
                                        
                                        out.println("<table border=\"1\">");
                                        out.println("<tbody>");
                                        out.println("<tr>");
                                        out.println("<td><input type=\"checkbox\" name=\""+"id"+nuevaLista.get(i).getIdencuentro()+"\" value=\"ON\" />");
                                        out.println(""+nuevaLista.get(i).getEscenario()+ "<td>"+nuevaLista.get(i).getFecha()+"</td>");
                                        out.println("</tr>");
                                        
                                        out.println("<tr>");
                                        out.println("<td>"+nuevaLista.get(i).getEquipoByEquipoIdequipo().getNombre()+"</td>");                                        
                                        out.println("<td>"+"<input type=\"text\" name=\""+"E1"+nuevaLista.get(i).getIdencuentro()+"\" value=\"\" size=\"3\" />"+"</td>");
                                        out.println("</tr>");
                                        
                                        out.println("<tr>");
                                        out.println("<td>"+nuevaLista.get(i).getEquipoByEquipoIdequipo1().getNombre()+"</td>");
                                        out.println("<td>"+"<input type=\"text\" name=\""+"E2"+nuevaLista.get(i).getIdencuentro()+"\" value=\"\" size=\"3\" />"+"</td>");
                                        out.println("</tr>");
                                        
                                        out.println("<td>Apuesta"+"<input type=\"text\" name=\""+nuevaLista.get(i).getIdencuentro()+"Monto"+"\" value=\"\" size=\"3\" />"+"</td>");
                                                                                
                                        out.println("</tr>");
                                        out.println("</tbody>");
                                        out.println("</table>");
                                        
                                        out.println("</td>");
                                        cnt++;
                                        if(cnt == 5){
                                            cnt = 0;
                                            out.println("</tr>");
                                            out.println("</tbody>");
                                            out.println("</table>");                                            
                                            out.println("<div id=\"templatemo_main\"></div>");
                                        }                                                                                                                                                                                                       
                                        i++;
                                     }
                                    
                            %>
                         <td><input type="hidden" name="username" value=<% out.println(username);%>> </td>
                                    <td>
                                        
                                    </td>
                                                    
                            </tbody>
                        </table>        
                                    <input type="submit" value="Agregar " name="addBet" />
                    </form>
                    
                
                
                    <script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
                    <script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
                    <script type="text/javascript">
                    $(window).load(function() {
                        $('#slider').nivoSlider();
                    });
                    </script>
                <div class="cleaner"></div>
            </div> <!-- end of middle -->

                <div id="templatemo_main_wrapper">
                <div id="templatemo_main">
                        
                </div> <!-- end of main -->
            </div> <!-- end of main wrapper -->

        </div> <!-- end of wrapper -->

        <div id="templatemo_footer_wrapper">
                
               
            
        </div>

        </body>
</html>
