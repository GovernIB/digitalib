
<br/>
<p lang="ca-ES" style="margin-bottom: 0cm; line-height: 100%"><font face="Consolas, monospace">
<font size="2" style="font-size: 11pt">
Manual d'&uacute;s del m&ograve;dul d&rsquo;estadístiques de DigitalIB
<br/>
<br/>
<br/>
<br/>

1.- Consulta de Transaccions<br/>
============================<br/>
<br/>
La ruta a la consula de transaccions es troba en aquesta ruta:<br/><br/>

   <b>http://HOST:PORT/digitalibapi/estadistiques/v1/consulta</b>

<br/>
<br/>
Els par&agrave;metres que pot adquirir aquest servei s&oacute;n:<br/>
</font></font> 
</p>
<p lang="ca-ES" align="left" style="margin-bottom: 0cm; line-height: 100%">
<font face="Consolas, monospace"><font size="2" style="font-size: 11pt"><font color="#2a00ff">

* <b>startdate</b>: data d&rsquo;inici de la consulta. Opcional. Format dd-mm-yyyy<br/>
* <b>enddate</b>: data final de la consulta. Opcional. Format dd-mm-yyyy<br/>
* <b>appname</b>: username de l&rsquo;app. Opcional. Nom&eacute;s es pot elegir appname o usrname a la vegada<br/>
* <b>usrname</b>: username de la persona. Opcional. Nom&eacute;s es pot elegir appname o usrname a la vegada<br/>
* <b>estat</b>: Estat en que es troba la transacci&oacute;.  Opcional. Valors possibles s&oacute;n: &quot;EXPIRAT&quot;,&quot;CANCELAT&quot;,&quot;ERROR&quot;,&quot;ID&quot;,&quot;ENPROGRES&quot;,&quot;OK&quot;<br/>

</font></font></font>
</p>
<br/>
<br/>
<p lang="ca-ES" style="margin-bottom: 0cm; line-height: 100%">
<font face="Consolas, monospace"><font size="2" style="font-size: 11pt">Exemples:
</p>
* <a target="_blank" href="./consulta?startdate=01-12-2021" style="text-decoration: underline;">consulta?startdate=01-12-2021</a></p>
* <a target="_blank" href="./consulta?startdate=01-12-2021&estat=ERROR" style="text-decoration: underline;">consulta?startdate=01-12-2021&amp;estat=ERROR</a><br/>
