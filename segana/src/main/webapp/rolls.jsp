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
        String x = request.getParameter("email");
        String username=(String) session.getAttribute("namen");
              
        if(session.getAttribute("admin")==null)
        {
            response.sendRedirect("admin.jsp");
            out.println("<p style=\"text-align:center;\"><a href=\"#\" >"+ username +"</a> , <a href=\"logout.jsp\" >Logout</a></p> ");
        }
        if(username==null && x!=null)
        {
            session.setAttribute("namen", x);                       
            out.println("<p style=\"text-align:center;\"><a href=\"#\" >"+x+"</a> , <a href=\"logout.jsp\" >Logout</a></p> , ");
        }
        else if(x!=null)
        {
            out.println("<p style=\"text-align:center;\"><a href=\"#\" >"+x+"</a> , <a href=\"logout.jsp\" >Logout</a></p> , ");
        }
        else if(username!=null)
        {
            out.println("<p style=\"text-align:center;\"><a href=\"#\" >"+ username +"</a> , <a href=\"logout.jsp\" >Logout</a></p> ");
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
                        <li><a href="blog.html"><span></span>Cuenta</a>
                            <ul>
                                    <li><a href="addCard.jsp">Agregar Tarjeta</a></li>
                                   <!--<li><a href="register.jsp">Sign up (Create account)</a></li>  -->                               
                            </ul>
                        </li>
                        
                    </ul>
                    <br style="clear: left" />
                </div> <!-- end of menu -->
            </div> <!-- end of header -->

            <div id="templatemo_middle">
                <div id="templatemo_middle_left">
                        <h2>Administration <strong>Se gana Gambling</strong></h2>
                    <p></p>                    
                </div>                
                <div class="cleaner"></div>
            </div> <!-- end of middle -->

                <div id="templatemo_main_wrapper">
                <div id="templatemo_main">
                        <div id="content">
                                        <div class="post">
                        <h2>Users and Access </h2>                        

                            
                            <p></p>                            
                            <div class="cleaner"></div>
                                        </div>
                        
                        <div class="cleaner"></div>
                    </div>
                    <div id="sidebar">
                        <div id="templatemo_search">
                            <form action="#" method="get">
                            <input type="text" value="Search" name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
                            <input type="submit" name="Search" value="" alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
                            </form>1                            
                        </div>

                        <div class="sb_box">
                            <h3>Categories</h3>
                            <ul class="templatemo_list">
                                <li><a href="rolls.jsp">System Users</a></li>
                                <li><a href="#">Show Modules</a></li>
                                <li><a href="#">-</a></li>
                                <li><a href="#">-</a></li>
                                <li><a href="#">-</a></li>
                                <li><a href="#">-</a></li>
                                <li><a href="#">-</a></li>
                            </ul>
                                        </div>
                       
                    </div> <!-- end of sidebar -->

                    <div class="cleaner"></div>
                </div> <!-- end of main -->
            </div> <!-- end of main wrapper -->

        </div> <!-- end of wrapper -->       

        </body>
</html>
