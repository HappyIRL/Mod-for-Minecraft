
# A Minecraft Mod

A mod I made to play on the LiveOverflow server.

Includes:
- A simple wrapper for the fabric implementation of the Mojang/brigadier
    - Tries to make the implementation of commands easier.
    - Usage: 
        - Implement a ClientCommand interface and populate the methods with your logic.
        - Create an instance of RegisterCommandHandler and use the registerCommand(ClientCommand) method to register your commands.

- Fabric Mixins to play on LiveOverflow's server:
    - ClientGameStateChangeEventMixins
        - Removes the fake demo message and game won screen.
    
    - PlayerPositionFullPacketMixin & PlayerPositionPacketMixin
        - Rounds player position to 1/100th before it gets sent to the server.

    - VehicleMoveEventPacketMixin & Accessor
        - Rounds player child entities (boats etc.) to 1/100th before it gets sent to the server.

    - WorldBoarderChangePacketMixin
        - Removes the fake world boarder.


## Authors

- [@HappyIRL](https://www.github.com/HappyIRL)

