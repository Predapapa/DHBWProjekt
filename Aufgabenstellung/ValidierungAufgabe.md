#Prüfungsaufgaben zu Validierung


###Aufgabe 1:

Bearbeiten Sie die Klasse **CarDTO.java**, sodass beim Anlegen eines Autos die eingegebenen Werte auf folgenden Wertebeschränkungen validiert werden:
- Der Wert von "model" sollte nicht null sein und nicht aus einem leeren String bestehen.
- Der Wert von "brand" sollte nicht null sein, nicht aus einem leeren String bestehen, keine Zahlen und keine Sonderzeichen enthalten.
- Der Wert von "km" sollte größer als 0 sein.
- Der Wert von "fuel" sollte entweder "DIESEL" oder "BENZIN" betragen.
- Das Attribut "year_of_production" sollte einen Wert zwischen 1902 und 2022 haben.

###Aufgabe 2:

Bearbeiten Sie die Klasse **CarDTO.java**, sodass beim Anlegen eines Autos das in folgender Wahrheitstafel dargestellte Verhalten realisiert werden kann:

<table>
<thead>
  <tr>
    <th>Attribut</th>
    <th>Eingabe</th>
    <th>Verhalten</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>currency</td>
    <td>null</td>
    <td>Fehlermeldung</td>
  </tr>
  <tr>
    <td>currency</td>
    <td>USD</td>
    <td>Fehlermeldung</td>
  </tr>
  <tr>
    <td>currency</td>
    <td>EUR</td>
    <td>Erfolg</td>
  </tr>
  <tr>
    <td>price</td>
    <td>null</td>
    <td>Fehlermeldung</td>
  </tr>
  <tr>
    <td>price</td>
    <td>-5621</td>
    <td>Fehlermeldung</td>
  </tr>
  <tr>
    <td>price</td>
    <td>0</td>
    <td>Fehlermeldung</td>
  </tr>
  <tr>
    <td>price</td>
    <td>25694,5678</td>
    <td>Fehlermeldung</td>
  </tr>
  <tr>
    <td>price</td>
    <td>25694</td>
    <td>Erfolg</td>
  </tr>
  <tr>
    <td>number_of_owners</td>
    <td>null</td>
    <td>Fehlermeldung</td>
  </tr>
  <tr>
    <td>number_of_owners</td>
    <td>-5</td>
    <td>Fehlermeldung</td>
  </tr>
  <tr>
    <td>number_of_owners</td>
    <td>0</td>
    <td>Fehlermeldung</td>
  </tr>
  <tr>
    <td>number_of_owners</td>
    <td>1, 2, 3, ..., n</td>
    <td>Erfolg</td>
  </tr>
  <tr>
    <td>owner</td>
    <td>null</td>
    <td>Fehlermeldung</td>
  </tr>
  <tr>
    <td>owner</td>
    <td>Valides OwnerDTO Objekt</td>
    <td>Erfolg</td>
  </tr>
</tbody>
</table>

##Regex Cheat-Sheet:

- **Nur Buchstaben**: ^[\p{L} .'-]+$
- **String1 oder String2**: ^(String1|String2)*$
- **Nur String1**: ^(String1)*$
