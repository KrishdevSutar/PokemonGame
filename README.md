# PokemonGame

**A side project to meant ot resemble the classic game Pokemon built using OOP principles in Java.**

![logo](https://github.com/KrishdevSutar/PokemonGame/blob/master/ScreenShots/MainScreen.PNG)

Inspiration

I have always wanted to create my own game so I took it upon myself to do it. I had just learned how to programm using Java so in order to test my understanding of the language and the OOP principles, I built this game.

What it does

You play as a Pokemon Trainer and your goal is to beat all 7 trainers in this route.You will get a choice between three Pokemon: Charizard the Fire type, Blastoise the Water type, and Venasaur the Grass type. Each Pokemon has 4 attacks, choose wisely on hwo you wish to fight to because type advantage matters. Whoever health drop to zero first wins the battle. If your health drops to zero before your opponent, then you lose and you will have to start from the very beginning. Once you have won a battle, your health will reset to its orignal value. The grass contains wild Pokemon

![logo](https://github.com/KrishdevSutar/PokemonGame/blob/master/ScreenShots/BattleScreen.PNG)

How we built it

I used object-oriented programming in Java Eclipse to build a Player class, Pokemon class, and Opponent class where it stored the information pertaining to them and was designed with encapsulation and interfacing in mind. The GUI was done through the use of imported files like javax.swing and java.awt where the main screen(aka which the player interacts with by walking around) and the battle screen. The battle system was made by creating another screen which ran a new thread, seperate from the main thread running the main screen thus incoporating multi-threading.

Challenges we ran into

The battle screen was a major issue as it would infinity create screens when moving in the grass as the player was never intended to leave the grass area so assuming the condiont was always true. I had to set many sub conditions to help trigger battle screen only once till the screen was exited.

Accomplishments that we're proud of

This entire project is something I am extremely pround of as it I had to learn many things from scratch and was able to produce a well-done result.
