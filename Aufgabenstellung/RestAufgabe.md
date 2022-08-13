#Prüfungsaufgaben zu REST

###Aufgabe 1:

Erstellen Sie die Methode **getOwner** in dem RestController **OwnerController**.

1. Kreieren Sie hierfür eine Methode in **OwnerService**, welche einen neuen Owner in dem Repository speichert. Der RestController soll die Service-Methode aufrufen.

2.  Falls der Owner nicht gefunden werden sollte (NoSuchElementException), soll eine **HttpStatus.NOT_FOUND** (ResponseStatusException) Exception geworfen werden.


###Aufgabe 2 – Rest-Test:

1.  Verfassen Sie einen statischen Unit Test zur OwnerControllerImpl Methode addOwner. Die Testmethode soll den Namen **shouldAddOwner** haben. Diese Methode soll in der Datei **OwnerRestControllerTestUT** hinzugefügt werden.

2.  Schauen Sie sich die Methode getOwnerCarPrice() im **OwnerControllerImpl** an. Verändern Sie die Testmethode **shouldSuccessfullyGetOwnerCarPrice()** in der **OwnerRestControllerTestImpl**, damit der Test erfolgreich durchläuft und die Testmethode korrekt testet.

