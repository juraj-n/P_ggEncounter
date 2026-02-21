# ggEncounter
A Java based Dungeon Master helper tool that provides interactive game board for managing characters, maps, props and sound effects during a D&D session.

## Features & Control
**Interactive Game Board**
- Add Enemy entity images to the board
  - *"Skull Button"*
- Select and move characters
  - *Left-Click Mouse Button* (Click-to-Select and Click-to-Place)
- Rotate characters to indicate direction
  - *Right Arrow* (=>)
- Mark characters as Dead (Black&White)
  - *Right-Click Mouse Button*

**Changing Background**
- Change the game board background (e.g. Default to Ship)
  - *"Picture Button"*

**Audio Playback**
- Play sound effects or music (e.g. LevelUp effect)
  - *"Treble-Clef Button"*

**Props System**
- Add different props (e.g. Barrel)
  - *Wheel-Click Mouse Button*
- Use props to represent obstacles or objects on the grid

## Learning Outcome
- Improved OOP skills in Java
- Using simple game engine to work with 2D graphics and handling mouse inputs
- Basic audio playback in Java
- Files and Directories reading
- Designing a tool with simple DMs needs in mind

## Tech Stack
- **Language:** Java
- **Library:** Simple Game Engine library ( https://github.com/infjava/shapesge.git )
- **Tools:** IntelliJ IDEA, Git, GitHub

## Preview
![Game Board Preview](/doc/preview.png)

## Notes

### Adding Audio Files
If user wants to add some new audio files which they can play during the session they need to:
1. Find "res" folder
2. Navigate to "audio" folder
3. Place *.wav* file inside audio folder
   1. Name of the file will be shown when choosing the audio to play (e.g. LevelUp.wav == "LevelUp")

### Adding New Entities
If user wants to add some new entity which they can place onto the game board during the session they need to:
1. Find "res" folder
2. Navigate to "pics" folder
3. Navigate to "entity" folder
4. And new *folder* (e.g. zombie)
   1. Name of this folder will be shown when choosing the entity to place
5. Inside this *folder* four *.png* files needs to be places
   1. *alive.png* - which will be shown on the game board at first
   2. *dead.png* - which will be shown when entity is "dead"
   3. *marked.png* - which will be shown when entity is marked
   4. *real1.png* - which will be shown when entity is marked on the right hand side

### Adding New Background
If user wants to add some new background which they can show on the game board during the session they need to:
1. Find "res" folder
2. Navigate to "background" folder
3. Place *.png* file inside background folder
   1. Name of the file will be shown when choosing the background (e.g. Default.png == Default)

## TODO
- Add an in-app option for uploading images directly into the appropriate folders  
  (entities, props, backgrounds) without requiring manual file placement
- Improve background scaling so users do not need to manually set static width and height values
- Apply the same dynamic scaling behavior to entities and props
- Add the ability to save an encounter and load it later with all entities, props, and positions restored
    - Triggered via the *"Crossed-Swords Button"*
- Repair Character Move boundaries