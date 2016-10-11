import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{
    public final static int TIEMPO_NIVEL = 15;
    private Counter contVidas;
    private Counter contGusanos;
    private Counter countTiempo;
    private Crab crab;
    private Lobster lobster;
    private SimpleTimer reloj;
    private int c=0;
    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1); 
        contGusanos = new Counter("Gusanos: ");
        addObject(contGusanos,64,20);
        contVidas = new Counter("Vidas ");
        contVidas.setValue(3);
        addObject(contVidas,200,20);
        countTiempo = new Counter("Tiempo: ");
        addObject(countTiempo,500,20);
        prepare();
        countTiempo.setValue(TIEMPO_NIVEL);
        reloj = new SimpleTimer();
    }
    
    public void cangrejoAtrapado()
    {
         vidaMenos();
         crab.setLocation(297,300);
         lobster.setLocation(200,92);
         if(contVidas.getValue()<0)
         {
             Label etiquetaFin = new Label("Game Over",50);
             addObject(etiquetaFin,250,250);
             Greenfoot.stop();
         }
    }
    
    public void agregarGusano(int t)
    {
        int x;
        int y;
        if(t == 3)
        {
           c=0;
           Worm worm = new Worm();
           x=Greenfoot.getRandomNumber(559);
           y=Greenfoot.getRandomNumber(559);
           if(y<80)
           {
               y=100;
           }
           addObject(worm,x,y);
        }
    }
    
    public void atrapaGusano()
    {
       List L = getObjects(Worm.class);
       contGusanos.add(1);
        if(L.isEmpty())
       { 
           Label etiquetaGana = new Label("Winner ",50);
           addObject(etiquetaGana,250,250);
           Greenfoot.stop();
       }
    }
    
    public void vidaMenos()
    {
        contVidas.add(-1);
    }
    
    public void act()
    {
        if(reloj.millisElapsed() >= 1000)
        {
            c++;
            reloj.mark();
            countTiempo.add(-1);
            perder();
            agregarGusano(c);
       }
    }

    public void perder()
    {
        if(countTiempo.getValue() == 0)
            {
                Label etiquetaTFin = new Label("Game Over",50);
                addObject(etiquetaTFin,250,250);
                Greenfoot.stop();
            }
    }
    
    public void incrementaGusanos()
    {
        contGusanos.add(1);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Worm worm = new Worm();
        addObject(worm,372,294);
        Worm worm2 = new Worm();
        addObject(worm2,214,178);
        Worm worm3 = new Worm();
        addObject(worm3,214,178);
        Worm worm4 = new Worm();
        addObject(worm4,414,104);
        Worm worm5 = new Worm();
        addObject(worm5,291,93);
        Worm worm6 = new Worm();
        addObject(worm6,90,216);
        Worm worm7 = new Worm();
        addObject(worm7,162,371);
        Worm worm8 = new Worm();
        addObject(worm8,371,516);
        Worm worm9 = new Worm();
        addObject(worm9,371,516);
        Worm worm10 = new Worm();
        addObject(worm10,222,502);
        crab = new Crab();
        addObject(crab,297,300);
        lobster = new Lobster();
        addObject(lobster,200,92);
    }
    
    public void started()
    {
        reloj.mark();
    }
    /*
    public void stopped()
    {
        System.out.println("Boton pause presionado");
    }*/
}
