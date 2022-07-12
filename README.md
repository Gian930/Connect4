# Connect 4

Connect 4 is a CLI program written in Java, which allows to play a simple game with the homonymous board game. If you want to see rules and curiosities, here's [this Wikipedia page](https://en.wikipedia.org/wiki/Connect_Four), or you can check my report [here](./Relazione_Forza_4.pdf).

## 🚀 Features

- create a new game with two new player
- load a previous saved game
- multiple saves
- winning animation
- exit the program using command line

## ❓ How does it work

In order to play a new game the program creates a new board with two different pieces then ask to both players their name, and that's it! Every turn the current player choose an available column and the prograram check automatically if there's a winner.

During the game both player can save the current match in a file, and later loading it simply by typing the file's name, or quit the game at any time.

Check [Usage](#✔️-usage) for commands details.

## ⚠️ Requirements and run

In order to work properly, Connect 4 needs this external program installed:

- **Java 8+**
- A Java IDE in order to run the game in console. For convenience I recommend Eclipse IDE (if you don't have it you can download Eclipse [here](https://www.eclipse.org/downloads/)) and make sure you have this setting:
  - Encoding "UTF-8": Window -> Preferences -> General -> Workspace -> Text file encoding -> (if you have by default Cp1252) Other -> UTF-8)

## ✔️ Usage

Connect 4 have some command line you can write during the game you may want to know:
  
- `-h` or `--help` if you want to know how to save the current state of the game
- `save filename` it's the command you have to write if you want to save the match
- `exit` of `quit` if you want to exit the program

You don't have to know anything else because for other things the programs tells you what to write in input.

## 📖 Documentation

If you want to see the official documentation you can check the `docs` folder, or you can see it directly in the source code.

