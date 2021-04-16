### UDP utilitzant Objectes
>**Tasca 3**  
>Implementar el mateix joc de la tasca 2 però amb objectes  
>Feu que:
> - Una instàcia de la classe `Tauler.java` és la que s'envia als clients perquè aquests estiguin al corrent de l'evolució del joc
> - Una instància de la classe `Jugada.java` és la que s'envia al servidor per indicar-li quin *usuari/client/jugador* ha fet la tirada i quin 
> valor té aquesta jugada
> - Que el servidor imprimeixi les jugades de cada jugador per la seva consola i l'estat del joc (Tauler)
> - Que el client imprimexi l'estat del joc (Tauler) per la seva consola  

<hr>
Recordatori:

```java
// Per enviar -> escriure al buffer
ByteArrayOutputStream os = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(os);
oos.writeObject(j);
```
```java
// Per llegir l'array de bytes (data) rebut del packet
ByteArrayInputStream in = new ByteArrayInputStream(data);
ObjectInputStream ois = new ObjectInputStream(in);
t = (Tauler) ois.readObject();
```

