Ghostly
=====

Ghostly is a helicopter clone written using Java with the LibGDX framework. You play as a ghost navigating through a series of infinite walls. The goal of the game is to survive for as long as possible and get the highest score. 

Story 
=====

You play as a ghost who, unlike the rest of the ghosts, lacks the ability to move through walls. You must navigate him through each wall to try and get the highest score.

Modules & Directories 
====

The reason that the game is split into various modules (Main -> Android, Desktop) is because of LibGDX's cross platform abilities. All of the game's main code, which runs cross platform between each individual system, can be found in the Main module's src directory.

Assets
====

The game's assets can be found in the Android Module's assets directory. 

UI
====

Although LibGDX does have a native UI, I've found that the documentation regarding UI skinning and parson of .json/.pack files to be quite lacking. I've found tutorials written on the subject, but most of these tutorials are written by the people who probably shouldn't be writing tutorials. Because of this native UI issue, I've decided to build my own simple UI using LibGDX sprites. 
