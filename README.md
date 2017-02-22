# Link++
<h3>Introduction</h3>
Existing interlinking tools focus on finding similarity relationships between entities of distinct RDF datasets by generating owl:sameAs links.
These approaches address the detection of equivalence relations between entities.
However, in some contexts, more complex relations are required, and the links to be defined follow more sophisticated patterns.
We introduce <b>Link++</b>, an approach that enables the discovery of complex links in a flexible manner.
<b>Link++</b> enables the users to generate rich links by defining custom functions and linking patterns that fit their needs.
<hr />
<h3>Instructions</h3>
This repository contains the executable file link_pp.jar that can be launched via running the batch files run.bat for the command lind interface version or run GUI.bat for a graphical user interface version.
Please follow this link for a quick introduction about the GUI version: https://www.youtube.com/watch?v=u2gr7Wa4eT4.
<br />
After running the command line program the program will show its usages.
In addition to the executable file we have included the following files as a sample scenario:
<ul>
  <li><i>sncf.ttl</i> a turtle file containing data about SNCF's stop locations. SNCF is a railway company in France see http://www.sncf.com/.
  The data was downloaded from http://gtfs.s3.amazonaws.com/sncf_20131211_1451.zip
  </li>
  <li><i>velib.ttl</i> a turtle file containing data about VELIB's bike station data. VELIB is a bike sharing company in France http://en.velib.paris.fr/. The data was downloaded from http://opendata.paris.fr/explore/dataset/stations-velib-disponibilites-en-temps-reel/
  </li>
  <li><i>linking-rule</i> a sample linking rule with a goal of connecting data entities that are X kilometers apart.
  Note that this file can be changed to fit any other linking task based on the user's need</li>
  <li><i>output-pattern</i> a sample file specifying what connection pattern a user wants as an output for a given matching task.
  In this scenario the output pattern generated information about the calculated distance and the duration between two transportation entities.
  <li><i>classes</i> a folder containing a compiled version of any function a user needs for a linking task.
  Users may use any external library as well but it is required that the used library exists in the classes folder.</li>
  <li><i>output</i> a folder containing the output of a linking process</li>
</ul>
<hr />
<h3>Publications</h3>
<ul>
  <li>Ali Masri, Karine Zeitouni, Zoubida Kedad, and Bertrand Leroy: <b> An Automatic Matcher and Linker for Transportation Datasets.</b>ISPRS International Journal of Geo-Information 6, no. 1 (2017): 29.<br />Link: http://www.mdpi.com/2220-9964/6/1/29/htm
  </li>
  <li>Ali Masri, Karine Zeitouni, Zoubida Kedad, and Bertrand Leroy: <b>Discovering multimodal routes using connection patterns.</b>In Intelligent Transportation Systems (ITSC), 2016 IEEE 19th International Conference on, pp. 2360-2365. IEEE, 2016.<br />Link: http://ieeexplore.ieee.org/abstract/document/7795936/
  </li>
  <li>Ali Masri, Karine Zeitouni, Zoubida Kedad, Gabriel Képéklian:<b> Link++: A Flexible and Customizable Tool for Connecting RDF Data Sources.</b> ESWC (Satellite Events) 2016: 107-111<br />Link: http://link.springer.com/chapter/10.1007%2F978-3-319-47602-5_22
  </li>
</ul>
<hr />
<h3>Acknowledgments</h3>
This work is part of a PhD thesis supported by VEDECOM Institute http://vedecom.fr/en/ in collaboration with the University of Versailles Saint-Quentine-en-Yvelines - DAVID Laboratory http://www.david.uvsq.fr/.
<hr />
<h3>Contact information</h3>
For more information about the project or for any suggestions you are free to contact us at ali.masri@vedecom.fr
