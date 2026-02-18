package postavy.other;

import postavy.Postava;

public class Elf extends Postava {
    public Elf() { super("Elf\\", "res\\pics\\", 500, 0); }

    @Override
    public void setSkutocnaPodoba() { setRealPodoba("res\\pics\\Elf\\real1.png"); }
}
