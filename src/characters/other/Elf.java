package characters.other;

import characters.Character;

public class Elf extends Character {
    public Elf() { super("Elf\\", "res\\pics\\", 500, 0); }

    @Override
    public void setRealLook() { setRealLook("res\\pics\\Elf\\real1.png"); }
}
