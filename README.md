# KORONA.pos Client ScannerScale (API Application)
This example outlines the use of a scanner scale using the KORONA.pos Client API.  Please be aware that this is an API example application.  
This application is not part of KORONA and is not certified for live use.

## Requirements
- Java 1.7 or higher
- KORONIX 1.6 or higher (currently there is no Windows or MacOSX support)
- ScannerScale must be Datalogix Magellan 8500xt (or similar)
- Device must be connected with a single serial cable (USB or dual cable is not supported)
- Scanner must be setup to append a TAB after each scan code (see http://www.datalogic.com/eng/support-services/automatic-data-capture/downloads/programming-sheets-ps-109.html?search_prod=155)

## Setup
#### 1) Download application file and copy it to the POS
    Download: https://github.com/COMBASE/KORONA.pos-Client-ScannerScale/releases
    Place application file (scannerscale.jar) into /opt/koronaposj/bin/
#### 2) Connect Device
    The device has to be connected with a single servial cable to COM1.
#### 3) Add application to autostart
    Edit the file /opt/koronaposj/scripts/before_koronaposj and add the following two lines:
    
      stty –file=/dev/ttyS0 raw
      java -jar /opt/koronaposj/bin/scannerscale.jar
    
#### 5) Setup external system call
    Log into www.koronacloud.com and go to Settings > External System Calls.  Create a new external system call with the name "Get Weight" and use the following Display URL:
    
      http://localhost:8080/
      
    Then go to the Button Configuration and create a new button for the external system call.  This button will be used to get the weigth from the scale and assign it as item quantity.
    
#### 6) Retrieve master data and reboot the POS

