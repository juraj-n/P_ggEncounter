package herneProstredie;

import fri.shapesge.Obrazok;
import hudba.AudioPlayer;
import hudba.AudioReader;
import postavy.Deletable;
import postavy.EntityReader;
import postavy.Postava;
import postavy.entity.Entita;
import props.PropReader;
import props.Kulisa;
import javax.swing.JOptionPane;

public class HernaPlocha {
    private Obrazok pozadie;
    private final ZoznamPostav zoznamPostav;
    private final ZoznamProps zoznamProps;
    public HernaPlocha() {
        pozadie = new Obrazok("res\\pics\\pozadie\\Pozadie.png", 0, 0);
        pozadie.zobraz();

        zoznamPostav = new ZoznamPostav();
        zoznamProps = new ZoznamProps();
    }
    @SuppressWarnings("unused")
    public void oznac(int x, int y) {
        for (Postava postava : zoznamPostav.getZoznamPostav()) {
            if(postava.obsahujeSuradnice(x, y)) {
                postava.mark();
                break;
            }
        }
    }
    @SuppressWarnings("unused")
    public void kill(int x, int y) {
        for (Postava postava : zoznamPostav.getZoznamPostav()) {
            if(postava.obsahujeSuradnice(x, y)) {
                postava.kill();
                break;
            }
        }
    }
    @SuppressWarnings("unused")
    public void otoc() {
        for(Postava postava : zoznamPostav.getZoznamPostav()) {
            if(postava.getOznacena()) {
                postava.otocPostavu();
                break;
            }
        }
    }
    @SuppressWarnings("unused")
    public void delete() {
        for(Postava postava : zoznamPostav.getZoznamPostav()) {
            if(postava.getOznacena() && (postava instanceof Deletable)) {
                ((Deletable) postava).odstran();
                zoznamPostav.uberPostavu(postava);
                break;
            }
        }
    }
    @SuppressWarnings("unused")
    public void presun(int x, int y) {
        for (Postava postava : zoznamPostav.getZoznamPostav()) {
            if(!postava.obsahujeSuradnice(x, y) && postava.getOznacena() && postava.getZiva()) {
                postava.presunPostavu(x, y);
                break;
            }
        }
    }
    @SuppressWarnings("unused")
    public void zmenPlochu(int x, int y) {
        if(x >= 1000 && x <= 1100 && y >= 400 && y <= 500) {
            // String[] options = {"Zaklad", "Loď", "Tráva", "Mesto", "Dom"};
            int odpoved = JOptionPane.showOptionDialog(null, "Aké chcete pozadie?", null,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, WallpaperReader.wallpaperOptions, WallpaperReader.wallpaperOptions[0]);
            if(odpoved != JOptionPane.CLOSED_OPTION) {
                if(pozadie != null) {
                    pozadie.skry();
                    pozadie = null;
                }
                pozadie = new Obrazok("res\\pics\\pozadie\\" + WallpaperReader.wallpaperOptions[odpoved] + ".png", 0, 0);
                pozadie.zobraz();
                zoznamPostav.prekresli();
                zoznamProps.prekresli();
            }

        }
    }
    @SuppressWarnings("unused")
    public void pridajEnemy(int x, int y) {
        if(x >= 1100 && x <= 1200 && y >= 400 && y <= 500) {
            // String[] options = {"Zombie", "Skeleton", "Pirat", "Entita"};
            String[] options = EntityReader.entityNames;
            int odpoved = JOptionPane.showOptionDialog(null,"Akú postavu chcete pridať?", null,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (odpoved != JOptionPane.CLOSED_OPTION) {
                zoznamPostav.pridajPostavu(new Entita(options[odpoved]));
            }
        }
    }
    @SuppressWarnings("unused")
    public void pridajProp(int x, int y) {
        for (Postava postava :zoznamPostav.getZoznamPostav()) {
            if (postava.obsahujeSuradnice(x, y)) {
                return;
            }
        }
        for (Kulisa kulisa : zoznamProps.getZoznamProps()) {
            if (kulisa.obsahujeSuradnice(x, y)) {
                kulisa.skryKulisu();
                zoznamProps.uberKulisu(kulisa);
                return;
            }
        }
        if(x <= 1000) {
            int surX = x - (x % 50);
            int surY = y - (y % 50);
            int odpoved = JOptionPane.showOptionDialog(null,"Aký prop chcete pridať?", null,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, PropReader.propOptions, PropReader.propOptions[0]);
            if(odpoved != JOptionPane.CLOSED_OPTION) {
                String[] pomParts = PropReader.propOptions[odpoved].split("-");
                zoznamProps.pridajKulisu(new Kulisa(surX, surY, Integer.parseInt(pomParts[1]), PropReader.propOptions[odpoved]));
            }
        }
    }
    @SuppressWarnings("unused")
    public void playAudio(int x, int y) {
        if (x >= 1000 && x <= 1100 && y >= 500 && y <= 600) {
            try{
                int odpoved = JOptionPane.showOptionDialog(null, "Aké audio mám prehrať?", null,
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, AudioReader.audioOptions, AudioReader.audioOptions[0]);
                AudioPlayer.playAudio(AudioReader.audioOptions[odpoved]);
            }catch(Exception e) {
                System.out.println(e.getMessage());
                AudioPlayer.stopAudio();
            }
        }
    }
}
