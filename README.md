<a href="http://projectdanube.org/" target="_blank"><img src="http://projectdanube.github.com/xdi2/images/projectdanube_logo.png" align="right"></a>
<img src="http://projectdanube.github.com/xdi2/images/logo64.png"><br>

This is an "Example Requesting Authority" component for the XDI Connect protocol.

### XDI Connect

This is part of a set of projects related to XDI Connect:
* [xdi2-connect-core](http://github.com/projectdanube/xdi2-connect-core)
* [xdi2-connect-service](http://github.com/projectdanube/xdi2-connect-service)
* [xdi2-connect-auth-service](http://github.com/projectdanube/xdi2-connect-auth-service)
* [xdi2-connect-button-builder](http://github.com/projectdanube/xdi2-connect-button-builder)
* [xdi2-connect-example-ra](http://github.com/projectdanube/xdi2-connect-example-ra)

### Information

Example Requesting Authorities:

* [+acmenews](https://github.com/projectdanube/xdi2-connect-example-ra/wiki/acmenews) / **[+]!:uuid:0b0a38c7-1120-4194-ad4c-2f52acc0e1a5**
* [+acmepizza](https://github.com/projectdanube/xdi2-connect-example-ra/wiki/acmepizza) / **[+]!:uuid:843085a3-0136-4bbb-b0a6-2f0e8d091c87**
* [+acmeapp](https://github.com/projectdanube/xdi2-connect-example-ra/wiki/acmeapp) / **[+]!:uuid:89937447-82be-4fce-9640-7e0856255250**

### How to build

First, you need to build the main [XDI2](http://github.com/projectdanube/xdi2) and the 
[xdi2-connect-core](http://github.com/projectdanube/xdi2-connect-core) projects.

After that, just run

    mvn clean install jetty:run

Then the Example Requesting Authority is available at

	http://localhost:9204/

### Community

Google Group: http://groups.google.com/group/xdi2
