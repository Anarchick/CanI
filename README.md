# CANI
## This cross-version API is used to determine if an action can be safe performed without compromising the functionality of other plugins.

## Advantage
 - Avoid knowing the plugin which restricts the future action.
 - Perhaps, You can retrieve each plugin which restricts the action with extra data.
 - Support non-bukkit interaction like Economy, Permissions, etc.
 - Some bukkit methods does not call an event, so you can't know if the action is restricted or not. This API can help you to know it.
 - Some bukkit methods call an event, but after the action is done. This API can help you to know if the action is restricted before it is done.
 - Support all server versions, even if the plugin is not updated.
 - Retro-compatible with old server versions, If an event does not exist in the server API of this old version. 
 - Very easy to use !
 - No server performance impact !

## Inconvenience
 - Cannot be use asynchronously.
 - This API have to be famous to be useful (= used by a lot of plugins).

## Examples of uses cases
 - A plugin wants to remove an Entity, but maybe this entity is protected by another plugin.
 - A player wants transfer money/item to another one, but maybe another plugin restricts it because the other player is in another faction.
 - A plugin wants to know if it can place a block, but maybe this location is used by another plugin.
 - A plugin wants to set a slot in an inventory, but maybe another plugin restricts it.


## How to use it ?

For the plugin which wants to perform the action:
```java
// EntityRemoveEvent (Bukkit) or EntityRemoveFromWorldEvent (Paper) are not cancellable.
// Even if the event is not cancellable, you can use this API to know if the action is restricted or not.
// If in the future, the event is cancellable, older server's version will not be updated.
if (new CanIRemoveEvent(entity).ask().isDeclined()) {
    return;
}
```

The plugin which wants to perform the action is maybe an addon of the plugin which restricts the action. In this case use this code:
```java
final Response reponse = new CanIRemoveEvent(entity).ask();
// Support String... and JavaPlugin...
if (!reponse.isAcceptedOrOnlyDeclineBy(protectionPlugin)) {
    return;
}

// perform action
```

For the plugin which restricts the action:
```java
// CanI events are not cancellable, and you don't need to change EventPriority.
@EventHandler
public void onAskRemoveEntity(final CanIRemoveEvent event) {
    if (MY_ENTITY_MANAGER.isManaged(event.getEntity())) {
        // you can only decline the event.
        // Message and data are optional.
        event.decline(protectionPlugin, "This entity is managed by "+protectionPluginName, null);
    }
}
```


