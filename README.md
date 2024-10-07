# Modulith Demo

In this demo repo we implement a Client-Server for a board game, using a
modular monolith as the backend architecture.

## Why a modular monolith?

Modular monoliths allow the operator to keep things simple in terms of
deployment (compared to managing multiple microservices), and
changes/updates can by deployed more efficiently as only specific
modules/components need to be updated.

<figure>
<img src="./assets/images/ModulithDiagram.png" alt="Modulith" />
</figure>

# The Game, Architecture & Technology Stack

## The Game

The purpose of this demo is to illustrate the modular monolith
(modulith) architectural style, and the Apache
frameworks/libraries/runtimes that help build them.

Our demo takes the form of a board game with the ability to play other
players via a game server.

When the game client creates a new game, it registers itself with the
backend server.

Another game client can then join an awaiting game.

Once both players have placed their tiles, the game begins allowing
turns to be taken. As players successfully bombard their opponent tiles
will change from grey to red to indicate hits.

While playing the game, players can also utilize a chat feature. The
chat messages are between the host and challenger.

## Architecture & Technology Stack

The Client is implemented using JavaFX, and utilizes the Game server’s
REST endpoints via Apache CXF WebClient.

<figure>
<img src="./assets/images/BFF.png" alt="BFF" />
</figure>

Our Server is designed as a set of Backend-For-Frontend applications.

- Game - The core Game Server, and its RESTful endpoints.

- Home - A homepage for the game, and backend services for dynamic
  content.

- Admin - An admin page to provide statics.

- Datastore - A common data source used by each BFF stack.

The Server side is implemented as a collection of OSGi modules. The
modules take the form of API and IMPL bundles. The Datastore bundle
implements a container available service offering of its API. In this
fashion each BFF may avail of the common datasource.

The Server side also contains a pair of Web bundles, these manage WAR
file & their infrastructure.

## Apache Karaf: Modulith Runtime

Karaf is the modulith runtime, supporting a wide range of frameworks and
technologies.

We use Apache Karaf’s OSGi support for deployment, and runtime wiring.
We also make use of Apache Karaf feature descriptor file to help
simplify installing our demo.

## Apache CXF: JAX-RS

Apache CXF is an open source software project developing a Web services
framework.

``` java
private ActiveGames getActiveGames() {
    try {
        WebClient webClient = WebClient.create(host + "/cxf/game/getActiveGames")
                .accept(MediaType.APPLICATION_JSON);
        Response respGet = webClient.get();
        return respGet.readEntity(ActiveGames.class);
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
}
```

We use Apache CXF’s WebClient to use our Game server’s RESTful
endpoints.

## JavaFX

JavaFX is a software platform for creating and delivering desktop
applications, as well as rich web applications that can run across a
wide variety of devices.

<figure>
<img src="./assets/images/GamePlay.png" alt="GamePlay" />
</figure>

We use JavaFX for our client GUI.

# Build and run the demo.

The client and server projects are both Maven based, as such one need
only source JAVA_HOME, and MAVEN_HOME, and make both available on their
PATH.

Please review the ReadMe file in the client and server folders.

# Conclusions

The modulith architectural style provides development teams with
simplified deployment model, and baked in flexibility for scaling,
modification, and feature evolution. Apache Karaf excels at providing a
modulith runtime environment to support these kinds of projects.

# About the Authors

[Jamie
Goodyear](https://github.com/savoirtech/blogs/blob/main/authors/JamieGoodyear.md)

# Reaching Out

Please do not hesitate to reach out with questions and comments, here on
the Blog, or through the Savoir Technologies website at
<https://www.savoirtech.com>.

# With Thanks

Thank you to the Apache Karaf, CXF, ActiveMQ, and Camel communities.

\(c\) 2024 Savoir Technologies
