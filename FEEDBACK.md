### Overall

I think you are very close to concluding a real MVP!
If you tackle the issue with loading the images and the mouse, your program is basically working, because the logic for comparing cards and the timer is working fine!


The main issue with your program is what was expected at this point: having several entities that depended on each other, how to best pass references between these entities? You don't need to always instantiate objects inside other objects, you can instantiate objects and then pass references, as needed, using `setter` methods.
Tackling the issues mentioned above will make for a much better program.

Also, don't forget to improve how the game starts (menu with instructions, for instance) and how it ends (game over).

A better game yet would include points and increasing difficulty somehow. If you decide to add different types of cards, consider if Interfaces and/or inheritance can help you.

Overall, nice job dealing with abstraction (what each class represents) and encapsulation (your code is organized in methods with clear responsabilities)!

- check for unused methods and variables
- you can improve how you use access modifieres
	- check when a method can be `private`
	- what is `protected` used for?
	- do you need package access properties?

### Main.java
- nice and clean

### Game.java
- what is the purpose of your `start` method?
- why not extract here some of the logic of setting up the necessary objects for the game?

### Board.java
- nice, clean class, with clear responsabilities (create the board and the cards, determine matches and victories - because `Board` holds a reference to all the cards)

`ArrayList` v. `array`
- kudos for experimenting with a collection from the Java Framework to store your cards
- nevertheless, good old arrays are still valid
	- check if your game can benefit from how easy it is to access elements in an array (or nested array, in this case)
#### `initBoard`
- it's interesting how, in this method, each card's id is determined and shuffled
- on the other hand, you are using three `for-loop`s in this method
	- check if you can create the cards, assign id's and shuffle them in one `nested for`

### Card.java
- consider eliminating unused properties, methods and references
- when creating a card, you pass a `size` property on the constructor, that is never used
- why are you passing a reference to `Board` in the constructor of card?
- does `Card` need reference to a `MyMouse`?
- also, how many `MyMouse` objects are being created when you run the game?
- where is `backImage` initialized?
- beware of how you are initializing the `Picture` (resource's paths) - the problem loading the pictures arises from here
- otherwise, `Card` is a well design class - it clearly encapsulates the logic regarding each individual card (related to appearence, limits and comparing coordenates with the mouse, although `contains` is not the greatest method name!)


### MyMouse.java
- so, everytime a `Card` is created, a `MyMouse` object is created and you pass it the reference to the `Card` that created it
- basically, this is one of the challenges of this exercise, which relationships to establish between objects (which object needs which reference to other object)
- consider, in a real world scenario, how many boards and how many mouses you would need
- if the `Board` holds a reference to all the `Card`s, maybe `MyMouse` only needs a reference to `Board`
- as I believe you already know, simplegfx is adding 37 px to the method `getY` of `MouseEvent`; if you take that in consideration, the mouse will select the card when clicked