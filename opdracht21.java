import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.util.ArrayList;
import java.util.Random;

/**
  *
  * Description
  *
  * @version 1.0 from 26/05/2025
  * @Ivar Koldewijn
  * @Pascal van Goethem 
  **/

public class opdracht21 extends Applet {
  // Variabelen om met verschillende knoppen te gebruiken
  private String[] kaarten = { "sA", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "sJ", "sQ", "sK", "kA", "k2", "k3", "k4", "k5", "k6", "k7", "k8", "k9", "k10", "kJ", "kQ", "kK", "hA", "h2", "h3", "h4", "h5", "h6", "h7", "h8", "h9", "h10", "hJ", "hQ", "hK", "rA", "r2", "r3", "r4", "r5", "r6", "r7", "r8", "r9", "r10", "rJ", "rQ", "rK" };
  private int kaartenGebruikt = 0;
  private int aasWaarde1B = 0;
  private int aasWaarde11B = 0;
  private int aasWaarde1S = 0;
  private int aasWaarde11S = 0;
  private String kaart2Bank = "";
  private int split = 0;
  private String splitKaart = "";
  //

  private Label label1 = new Label();
  private Label label2 = new Label();
  private TextArea BankTextField = new TextArea("", 1, 1, TextArea.SCROLLBARS_NONE);
  private TextArea SpelerTextField = new TextArea("", 1, 1, TextArea.SCROLLBARS_NONE);
  private Button DeelButton = new Button();
  private Button KaartButton = new Button();
  private Button PasButton = new Button();
  private Button SplitButton = new Button();
  private Label TotaalPuntenBankLabel = new Label();
  private Label totaalPuntenSpelerLabel = new Label();
  private Label bKaart1 = new Label();
  private Label bKaart2 = new Label();
  private Label bKaart3 = new Label();
  private Label bKaart4 = new Label();
  private Label bKaart5 = new Label();
  private Label bKaart6 = new Label();
  private Label bKaart7 = new Label();
  private Label sKaart1 = new Label();
  private Label sKaart2 = new Label();
  private Label sKaart3 = new Label();
  private Label sKaart4 = new Label();
  private Label sKaart5 = new Label();
  private Label sKaart6 = new Label();
  private Label sKaart7 = new Label();
  private Label testlabel = new Label();
  private NumberField totaalBank = new NumberField();
  private NumberField totaalSpeler = new NumberField();
  private Label splitLabel = new Label();
  private Label sKaart8 = new Label();
  private NumberField splitEersteTotaal = new NumberField();
  private TextArea eindVeld = new TextArea("", 1, 1, TextArea.SCROLLBARS_NONE);
  private Button resetButton = new Button();
  // end attributes 
  public void init() {
    Panel cp = new Panel(null);
    cp.setBounds(0, 0, 1362, 465);
    add(cp);
    // start components
    
    label1.setBounds(288, 0, 110, 28);
    label1.setText("Bank");
    label1.setAlignment(Label.CENTER);
    label1.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(label1);
    label2.setBounds(952, 0, 110, 28);
    label2.setText("Speler");
    label2.setFont(new Font("Dialog", Font.PLAIN, 20));
    label2.setAlignment(Label.CENTER);
    cp.add(label2);
    
    DeelButton.setBounds(632, 16, 83, 25);
    DeelButton.setLabel("Deel");
    DeelButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        DeelButton_ActionPerformed(evt);
      }
    });
    cp.add(DeelButton);
    KaartButton.setBounds(632, 72, 83, 25);
    KaartButton.setLabel("Kaart");
    KaartButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        KaartButton_ActionPerformed(evt);
      }
    });
    KaartButton.setEnabled(true);
    KaartButton.setVisible(false);
    cp.add(KaartButton);
    PasButton.setBounds(632, 128, 83, 25);
    PasButton.setLabel("Pas");
    PasButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        PasButton_ActionPerformed(evt);
      }
    });
    PasButton.setEnabled(true);
    PasButton.setVisible(false);
    cp.add(PasButton);
    SplitButton.setBounds(632, 184, 83, 25);
    SplitButton.setLabel("Split");
    SplitButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        SplitButton_ActionPerformed(evt);
      }
    });
    SplitButton.setEnabled(true);
    SplitButton.setVisible(false);
    cp.add(SplitButton);
    bKaart1.setBounds(248, 48, 54, 68);
    bKaart1.setText("");
    bKaart1.setAlignment(Label.CENTER);
    bKaart1.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(bKaart1);
    bKaart2.setBounds(376, 48, 54, 68);
    bKaart2.setText("");
    bKaart2.setAlignment(Label.CENTER);
    bKaart2.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(bKaart2);
    bKaart3.setBounds(120, 136, 54, 68);
    bKaart3.setText("");
    bKaart3.setAlignment(Label.CENTER);
    bKaart3.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(bKaart3);
    bKaart4.setBounds(216, 136, 54, 68);
    bKaart4.setText("");
    bKaart4.setAlignment(Label.CENTER);
    bKaart4.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(bKaart4);
    bKaart5.setBounds(312, 136, 54, 68);
    bKaart5.setText("");
    bKaart5.setAlignment(Label.CENTER);
    bKaart5.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(bKaart5);
    bKaart6.setBounds(408, 136, 54, 68);
    bKaart6.setText("");
    bKaart6.setAlignment(Label.CENTER);
    bKaart6.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(bKaart6);
    bKaart7.setBounds(504, 136, 54, 68);
    bKaart7.setText("");
    bKaart7.setAlignment(Label.CENTER);
    bKaart7.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(bKaart7);
    sKaart1.setBounds(912, 48, 54, 68);
    sKaart1.setText("");
    sKaart1.setAlignment(Label.CENTER);
    sKaart1.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(sKaart1);
    sKaart2.setBounds(1040, 48, 54, 68);
    sKaart2.setText("");
    sKaart2.setAlignment(Label.CENTER);
    sKaart2.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(sKaart2);
    sKaart3.setBounds(784, 136, 54, 68);
    sKaart3.setText("");
    sKaart3.setAlignment(Label.CENTER);
    sKaart3.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(sKaart3);
    sKaart4.setBounds(880, 136, 54, 68);
    sKaart4.setText("");
    sKaart4.setAlignment(Label.CENTER);
    sKaart4.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(sKaart4);
    sKaart5.setBounds(976, 136, 54, 68);
    sKaart5.setText("");
    sKaart5.setAlignment(Label.CENTER);
    sKaart5.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(sKaart5);
    sKaart6.setBounds(1072, 136, 54, 68);
    sKaart6.setText("");
    sKaart6.setAlignment(Label.CENTER);
    sKaart6.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(sKaart6);
    sKaart7.setBounds(1168, 136, 54, 68);
    sKaart7.setText("");
    sKaart7.setAlignment(Label.CENTER);
    sKaart7.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(sKaart7);
    totaalBank.setBounds(288, 384, 110, 28);
    totaalBank.setText("");
    totaalBank.setEnabled(false);
    totaalBank.setEditable(false);
    
    totaalBank.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(totaalBank);
    totaalSpeler.setBounds(960, 376, 110, 28);
    totaalSpeler.setText("");
    totaalSpeler.setEditable(false);
    totaalSpeler.setEnabled(false);
    totaalSpeler.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(totaalSpeler);
    splitLabel.setBounds(1216, 16, 110, 20);
    splitLabel.setText("(Split Actief)");
    splitLabel.setForeground(Color.RED);
    splitLabel.setAlignment(Label.CENTER);
    splitLabel.setVisible(false);
    cp.add(splitLabel);
    sKaart8.setBounds(1248, 48, 54, 68);
    sKaart8.setText("");
    sKaart8.setAlignment(Label.CENTER);
    sKaart8.setFont(new Font("Dialog", Font.PLAIN, 25));
    cp.add(sKaart8);
    splitEersteTotaal.setBounds(632, 264, 83, 28);
    splitEersteTotaal.setText("");
    splitEersteTotaal.setEditable(false);
    splitEersteTotaal.setEnabled(false);
    splitEersteTotaal.setVisible(false);
    cp.add(splitEersteTotaal);
    eindVeld.setBounds(424, 312, 512, 100);
    eindVeld.setFont(new Font("Dialog", Font.PLAIN, 15));
    eindVeld.setEditable(false);
    eindVeld.setEnabled(false);
    eindVeld.setVisible(false);
    cp.add(eindVeld);
    resetButton.setBounds(632, 16, 83, 25);
    resetButton.setLabel("Opnieuw");
    resetButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        resetButton_ActionPerformed(evt);
      }
    });
    resetButton.setVisible(false);
    cp.add(resetButton);
    // end components
    
  } // end of init
  
  static int berekenWaardeKaart (String kaart) { //Functie om het aantal punten
    if (kaart.equals("A")) {                     //dat een kaart waard is te
      return 11;                                 //berekenen
    } else if (kaart.equals("2")) {
      return 2;
    } else if (kaart.equals("3")) {
      return 3;
    } else if (kaart.equals("4")) {
      return 4;
    } else if (kaart.equals("5")) {
      return 5;
    } else if (kaart.equals("6")) {
      return 6;
    } else if (kaart.equals("7")) {
      return 7;
    } else if (kaart.equals("8")) {
      return 8;
    } else if (kaart.equals("9")) {
      return 9;
    } else if (kaart.equals("10")) {
      return 10;
    } else if (kaart.equals("J")) {
      return 1;
    } else if (kaart.equals("Q")) {
      return 2;
    } else if (kaart.equals("K")) {
      return 3;
    } else {
      return 0;
    }
  }  
  
  
  
  private int kaartenBank () {
    Random random = new Random(); //Random variabele aanmaken
    
    int kaart2Waarde = berekenWaardeKaart(kaart2Bank.substring(1, kaart2Bank.length()));
    
    if (aasWaarde11B == 1 && kaart2Waarde == 11) {  //Kijken of er een aas is en die aas de goede punten geven (1/11)
      kaart2Waarde = 1;
      aasWaarde1B++;
    } else if (kaart2Waarde == 11) {
      aasWaarde11B++;
    }
      
    bKaart2.setText(kaart2Bank.substring(1, kaart2Bank.length())); //Kaart invullen
    
    if (kaart2Bank.substring(0,1).equals("h") || kaart2Bank.substring(0,1).equals("r")) { //Kaart rode kleur geven bij harten of ruiten
      bKaart2.setForeground(Color.RED);
    } else {
      bKaart2.setForeground(Color.BLACK);
    }
    
    int totaal = totaalBank.getInt() + kaart2Waarde; //Totaal invullen bij de bank
    totaalBank.setInt(totaal);
    
    if (totaal > 16) { //Automatisch passen bij 17 of hoger
      return totaal;
    } else {
      try {                                                                                       
        Thread.sleep(400);     //400ms wachten voor effect                                                                       
      } catch(Exception e) {                                                                       
        e.printStackTrace () ;                                                                    
      }
       
      int nieuweKaart3 = random.nextInt(kaarten.length - kaartenGebruikt); //nieuwe kaart pakken
      String nieuweKaart3Waarde = kaarten[nieuweKaart3];
      int nieuweKaart3Punten = berekenWaardeKaart(nieuweKaart3Waarde.substring(1,nieuweKaart3Waarde.length()));
      int nieuweKaart3Length = nieuweKaart3Waarde.length();
      
      for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) { //Kaart uit het dek halen                                                 
        if (i != nieuweKaart3) {                                                                        
          if (i > nieuweKaart3) {                                                                           
            kaarten[i-1] = kaarten[i];                                                            
          } // end of if                                                                          
        }                                                                                         
      }
      
      bKaart3.setText(nieuweKaart3Waarde.substring(1, nieuweKaart3Length)); //Kaart invullen
      bKaart3.setBackground(Color.LIGHT_GRAY);
      
      if (nieuweKaart3Waarde.substring(0,1).equals("h") || nieuweKaart3Waarde.substring(0,1).equals("r")) { //Kleur geven
        bKaart3.setForeground(Color.RED);
      } else {
        bKaart3.setForeground(Color.BLACK);
      } 
      
      totaal = totaal + nieuweKaart3Punten; //Totaal berekenen
      
      if (totaal + nieuweKaart3Punten > 21 && nieuweKaart3Punten == 11) {  //Controleren of er een aas ligt en alle aasen een goede waarde geven (1/11)
        totaal = totaal - 10;
        aasWaarde1B++;
      } else if (totaal + nieuweKaart3Punten > 21 && aasWaarde11B != 0) {
        for (int i = aasWaarde11B; i>0; i--) {
          if (totaal > 21) {
            aasWaarde11B--;
            totaal = totaal - 10;
          } // end of if
        } // end of for
      }
      
      totaalBank.setInt(totaal); //Totaal invullen
      
      if (totaal > 16) {  //Dit doorblijven doen tot 7 kaarten
        return totaal;
      } else {
        try {                                                                                       
          Thread.sleep(400);                                                                            
        } catch(Exception e) {                                                                       
          e.printStackTrace () ;                                                                    
        } 
        
        int nieuweKaart4 = random.nextInt(kaarten.length - kaartenGebruikt);
        String nieuweKaart4Waarde = kaarten[nieuweKaart4];
        int nieuweKaart4Punten = berekenWaardeKaart(nieuweKaart4Waarde.substring(1,nieuweKaart4Waarde.length()));
        int nieuweKaart4Length = nieuweKaart4Waarde.length();
        
        for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {                                                  
          if (i != nieuweKaart4) {                                                                        
            if (i > nieuweKaart4) {                                                                           
              kaarten[i-1] = kaarten[i];                                                            
            } // end of if                                                                          
          }                                                                                         
        }
        
        bKaart4.setText(nieuweKaart4Waarde.substring(1, nieuweKaart4Length));
        bKaart4.setBackground(Color.LIGHT_GRAY);
        
        if (nieuweKaart4Waarde.substring(0,1).equals("h") || nieuweKaart4Waarde.substring(0,1).equals("r")) {
          bKaart4.setForeground(Color.RED);
        } else {
          bKaart4.setForeground(Color.BLACK);
        } 
        
        totaal = totaal + nieuweKaart4Punten;
        
        if (totaal + nieuweKaart4Punten > 21 && nieuweKaart4Punten == 11) {
          totaal = totaal - 10;
          aasWaarde1B++;
        } else if (totaal + nieuweKaart4Punten > 21 && aasWaarde11B != 0) {
          for (int i = aasWaarde11B; i>0; i--) {
            if (totaal > 21) {
              aasWaarde11B--;
              totaal = totaal - 10;
            } // end of if
          } // end of for
        }
        
        totaalBank.setInt(totaal);
        
        if (totaal > 16) {
          return totaal;
        } else {
          try {                                                                                  
            Thread.sleep(400);                                                                   
          } catch(Exception e) {                                                                  
            e.printStackTrace () ;                                                              
          } 
          
          int nieuweKaart5 = random.nextInt(kaarten.length - kaartenGebruikt);
          String nieuweKaart5Waarde = kaarten[nieuweKaart5];
          int nieuweKaart5Punten = berekenWaardeKaart(nieuweKaart5Waarde.substring(1,nieuweKaart5Waarde.length()));
          int nieuweKaart5Length = nieuweKaart5Waarde.length();
          
          for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {                                    
            if (i != nieuweKaart5) {                                                                
              if (i > nieuweKaart5) {                                                                     
                kaarten[i-1] = kaarten[i];                                                           
              } // end of if                                                                        
            }                                                                                       
          }
          
          bKaart5.setText(nieuweKaart5Waarde.substring(1, nieuweKaart5Length));
          bKaart5.setBackground(Color.LIGHT_GRAY);
          
          if (nieuweKaart5Waarde.substring(0,1).equals("h") || nieuweKaart5Waarde.substring(0,1).equals("r")) {
            bKaart5.setForeground(Color.RED);
          } else {
            bKaart5.setForeground(Color.BLACK);
          } 
          
          totaal = totaal + nieuweKaart5Punten;
          
          if (totaal + nieuweKaart5Punten > 21 && nieuweKaart5Punten == 11) {
            totaal = totaal - 10;
            aasWaarde1B++;
          } else if (totaal + nieuweKaart5Punten > 21 && aasWaarde11B != 0) {
            for (int i = aasWaarde11B; i>0; i--) {
              if (totaal > 21) {
                aasWaarde11B--;
                totaal = totaal - 10;
              } // end of if
            } // end of for
          }
          
          totaalBank.setInt(totaal);
          
          if (totaal > 16) {
            return totaal;
          } else {
            try {                                                                                   
              Thread.sleep(400);                                                                    
            } catch(Exception e) {                                                                      
              e.printStackTrace () ;                                                                
            } 
            
            int nieuweKaart6 = random.nextInt(kaarten.length - kaartenGebruikt);
            String nieuweKaart6Waarde = kaarten[nieuweKaart6];
            int nieuweKaart6Punten = berekenWaardeKaart(nieuweKaart6Waarde.substring(1,nieuweKaart6Waarde.length()));
            int nieuweKaart6Length = nieuweKaart6Waarde.length();
            
            for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {                                              
              if (i != nieuweKaart6) {                                                                  
                if (i > nieuweKaart6) {                                                              
                  kaarten[i-1] = kaarten[i];                                                        
                } // end of if                                                                        
              }                                                                                      
            }
            
            bKaart6.setText(nieuweKaart6Waarde.substring(1, nieuweKaart6Length));
            bKaart6.setBackground(Color.LIGHT_GRAY);
            
            if (nieuweKaart6Waarde.substring(0,1).equals("h") || nieuweKaart6Waarde.substring(0,1).equals("r")) {
              bKaart6.setForeground(Color.RED);
            } else {
              bKaart6.setForeground(Color.BLACK);
            } // end of if-else
            
            totaal = totaal + nieuweKaart6Punten;
            
            if (totaal + nieuweKaart6Punten > 21 && nieuweKaart6Punten == 11) {
              totaal = totaal - 10;
              aasWaarde1B++;
            } else if (totaal + nieuweKaart6Punten > 21 && aasWaarde11B != 0) {
              for (int i = aasWaarde11B; i>0; i--) {
                if (totaal > 21) {
                  aasWaarde11B--;
                  totaal = totaal - 10;
                } // end of if
              } // end of for
            }
            
            totaalBank.setInt(totaal);
            
            if (totaal > 16) {
              return totaal;
            } else {
              try {                                                                                      
                Thread.sleep(400);                                                                     
              } catch(Exception e) {                                                                    
                e.printStackTrace () ;                                                                  
              } 
              
              int nieuweKaart7 = random.nextInt(kaarten.length - kaartenGebruikt);
              String nieuweKaart7Waarde = kaarten[nieuweKaart7];
              int nieuweKaart7Punten = berekenWaardeKaart(nieuweKaart7Waarde.substring(1,nieuweKaart7Waarde.length()));
              int nieuweKaart7Length = nieuweKaart7Waarde.length();
              
              for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {                                            
                if (i != nieuweKaart7) {                                                                      
                  if (i > nieuweKaart7) {                                                                     
                    kaarten[i-1] = kaarten[i];                                                        
                  } // end of if                                                                          
                }                                                                                       
              }
              
              bKaart7.setText(nieuweKaart7Waarde.substring(1, nieuweKaart7Length));
              bKaart7.setBackground(Color.LIGHT_GRAY);
              
              if (nieuweKaart7Waarde.substring(0,1).equals("h") || nieuweKaart7Waarde.substring(0,1).equals("r")) {
                bKaart7.setForeground(Color.RED);
              } else {
                bKaart7.setForeground(Color.BLACK);
              } // end of if-else
              
              totaal = totaal + nieuweKaart7Punten;
              
              if (totaal + nieuweKaart7Punten > 21 && nieuweKaart7Punten == 11) {
                totaal = totaal - 10;
                aasWaarde1B++;
              } else if (totaal + nieuweKaart7Punten > 21 && aasWaarde11B != 0) {
                for (int i = aasWaarde11B; i>0; i--) {
                  if (totaal > 21) {
                    aasWaarde11B--;
                    totaal = totaal - 10;
                  } // end of if
                } // end of for
              }
              
              totaalBank.setInt(totaal);     //Bij 7e kaart automatisch stoppen
              
              return totaal;
            } 
          } 
        } 
      }
    }
  }  
  
  
  // start methods
  public void DeelButton_ActionPerformed(ActionEvent evt) { 
    
    Random random = new Random();                                     
    DeelButton.setEnabled(false);   
    
    //Kaart 1 pakken
    int kaart1 = random.nextInt(kaarten.length - kaartenGebruikt);                               
    String kaart1Waarde = kaarten[kaart1];                                                      
    int kaart1Length = kaart1Waarde.length();                                                   
    
    for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {      //Kaart uit het dek halen                                            
      if (i != kaart1) {                                                                        
        if (i > kaart1) {                                                                           
          kaarten[i-1] = kaarten[i];                                                            
        } // end of if                                                                          
      }                                                                                         
    }                                                                                           
    
    bKaart1.setText(kaart1Waarde.substring(1,kaart1Length));         //Kaart neerleggen                               
    bKaart1.setBackground(Color.LIGHT_GRAY);                                                    
    
    if (kaart1Waarde.substring(0, 1).equals("h") || kaart1Waarde.substring(0, 1).equals("r")) { //Kaart kleur geven     
      bKaart1.setForeground(Color.RED);                                                            
    }                                                                                               
    
    kaartenGebruikt++;                                                                          
    int totaal = berekenWaardeKaart(kaart1Waarde.substring(1,kaart1Length));  //Totaal invullen                  
    if (totaal == 11) {                                                                         
      aasWaarde11B++;                                                                           
    } // end of if                                                                              
    totaalBank.setInt(totaal);  
                                                                    
    try {                                                                     //400ms wachten voor effect                  
      Thread.sleep(400);                                                                            
    } catch(Exception e) {                                                                       
      e.printStackTrace () ;                                                                    
    }                                                                                           
      
    //Kaart 2 pakken
    int kaart2 = random.nextInt(kaarten.length - kaartenGebruikt);                                 
    String kaart2Waarde = kaarten[kaart2];                                                      
    
    for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) { //Kaart uit het deck halen                                                 
      if (i != kaart2) {                                                                        
        if (i > kaart2) {                                                                           
          kaarten[i-1] = kaarten[i];                                                            
        } // end of if                                                                          
      }                                                                                         
    }                                                                                           
                                              
    bKaart2.setBackground(Color.LIGHT_GRAY);                     //Kaart blind neerleggen                               
    
    try {                                                        //Wachten voor effect                               
      Thread.sleep(400);                                                                            
    } catch(Exception e) {                                                                       
      e.printStackTrace () ;                                                                    
    } 
                                                                                              
    kaartenGebruikt = kaartenGebruikt + 1;                                                      
    kaart2Bank = kaart2Waarde;                                                                  
    
    //Kaart 3 pakken
    int kaart3 = random.nextInt(kaarten.length - kaartenGebruikt);                                  
    String kaart3Waarde = kaarten[kaart3];                                                      
    int kaart3Length = kaart3Waarde.length();                                                   
    
    for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {  //Kaart uit het dek halen                                                
      if (i != kaart3) {                                                                        
        if (i > kaart3) {                                                                            
          kaarten[i-1] = kaarten[i];                                                            
        } // end of if                                                                          
      }                                                                                         
    }  
    
    sKaart1.setText(kaart3Waarde.substring(1,kaart3Length));  //Kaart neerleggen                                       
    sKaart1.setBackground(Color.LIGHT_GRAY);                                                    
    
    if (kaart3Waarde.substring(0, 1).equals("h") || kaart3Waarde.substring(0, 1).equals("r")) {   //Kaart kleur geven 
      sKaart1.setForeground(Color.RED);                                                              
    }                                                                                              
    
    kaartenGebruikt = kaartenGebruikt + 1;                               //Totaal invullen                       
    totaal = berekenWaardeKaart(kaart3Waarde.substring(1,kaart3Length)); 
                           
    if (totaal == 11) {                                                                         
      aasWaarde11S++;                                                                           
    } // end of if      
                                                                            
    try {                      //Wachten voor effect                                                                 
      Thread.sleep(400);                                                                            
    } catch(Exception e) {                                                                       
      e.printStackTrace () ;                                                                    
    }                                                                                           
    
    //Kaart 4 pakken
    int kaart4 = random.nextInt(kaarten.length - kaartenGebruikt);                                   
    String kaart4Waarde = kaarten[kaart4];                                                      
    int kaart4Length = kaart4Waarde.length();                                                   
                                                                                                
    for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {  //Kaart uit het dek halen                                                
      if (i != kaart4) {                                                                        
        if (i > kaart4) {                                                                           
          kaarten[i-1] = kaarten[i];                                                            
        } // end of if                                                                          
      }                                                                                         
    }                                                                                           
    
    sKaart2.setText(kaart4Waarde.substring(1,kaart4Length));  //Kaart neerleggen                                      
    sKaart2.setBackground(Color.LIGHT_GRAY);                                                    
    
    if (kaart4Waarde.substring(0, 1).equals("h") || kaart4Waarde.substring(0, 1).equals("r")) { //Kleur geven
      sKaart2.setForeground(Color.RED);                                                         
    }                                                                                         
    
    kaartenGebruikt = kaartenGebruikt + 1;                                                      
    int totaal2 = totaal + berekenWaardeKaart(kaart4Waarde.substring(1,kaart4Length));  //Totaal berekenen
              
    if (totaal2 - totaal == 11 && totaal2 != 22) {   //Bij aasen de waarde goed zetten                                           
      aasWaarde11S++;                                                                           
    } else if (totaal2 == 22) {                                                                 
      totaal2 = 12;                                                                             
      aasWaarde1S++;                                                                            
    }                                                                                           
    totaalSpeler.setInt(totaal2);                                                               
    
    if (kaart3Waarde.substring(1,kaart3Length).equals(kaart4Waarde.substring(1,kaart4Length))) {  //Split knop laten verschijnen bij 2 dezelfde 
      SplitButton.setVisible(true);
      splitKaart = kaart4Waarde;
    } // end of if
    
    if (kaart3Waarde.substring(1,kaart3Length).equals("7") && kaart4Waarde.substring(1,kaart4Length).equals("8")) {         //Vuile was = knop om te stoppen
      resetButton.setVisible(true);
    } else if (kaart3Waarde.substring(1,kaart3Length).equals("8") && kaart4Waarde.substring(1,kaart4Length).equals("7")) {
      resetButton.setVisible(true);
    } // end of if-else
    
    KaartButton.setVisible(true);
    PasButton.setVisible(true);                                                                                            //Knoppen laten zien
    DeelButton.setVisible(false);
    
    if (totaal2 == 21) {
      KaartButton.setVisible(false);                                                                                       //Bij 21 automatisch passen
      PasButton.setVisible(false);
      int bankPunten = kaartenBank();
      if (bankPunten != 21) {
        eindVeld.setText("Speler heeft gewonnen van bank met 21!");
        eindVeld.setVisible(true);
      } else {
        eindVeld.setText("Bank wint!\nDe bank heeft gewonnen door gelijkspel.");
        eindVeld.setVisible(true);
      } // end of if-else
    } // end of if
  } // end of DeelButton_ActionPerformed
  
  public void KaartButton_ActionPerformed(ActionEvent evt) {
    Random random = new Random();
    
    int nieuweKaart = random.nextInt(kaarten.length - kaartenGebruikt);                                      //Nieuwe kaart kiezen
    String nieuweKaartWaarde = kaarten[nieuweKaart];
    int nieuweKaartPunten = berekenWaardeKaart(nieuweKaartWaarde.substring(1, nieuweKaartWaarde.length()));
    
    String slot3 = sKaart3.getText();  //Kijken welke kaarten al liggen
    String slot4 = sKaart4.getText();
    String slot5 = sKaart5.getText();
    String slot6 = sKaart6.getText();
    String slot7 = sKaart7.getText();
    
    for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) { //kaart uit het dek halen
      if (i != nieuweKaart) {
        if (i > nieuweKaart) {
          kaarten[i-1] = kaarten[i];
        } // end of if
      } // end of if
    } // end of for
    
    int totSpeler = totaalSpeler.getInt();
    
    if (nieuweKaartPunten == 11 && totSpeler + nieuweKaartPunten < 22) {            //Waarde van aasen goed zetten
      aasWaarde11S++;
    } else if (nieuweKaartPunten == 11 && totSpeler + nieuweKaartPunten > 21) {
      aasWaarde1S++;
      nieuweKaartPunten = 1;
    } else if (totSpeler + nieuweKaartPunten > 21 && aasWaarde11S != 0) {
      for (int i = aasWaarde11S; i>0; i--) {
        if (totSpeler + nieuweKaartPunten > 21) {
          aasWaarde11S--;
          totSpeler = totSpeler - 10;
        } // end of if
      } // end of for
      totaalSpeler.setInt(totSpeler);
    }
    
    
    if (slot3.equals("")) {                                                                                  //Kaart op de goede plek neerleggen
      sKaart3.setText(nieuweKaartWaarde.substring(1, nieuweKaartWaarde.length()));
      sKaart3.setBackground(Color.LIGHT_GRAY);
      
      if (nieuweKaartWaarde.substring(0,1).equals("h") || nieuweKaartWaarde.substring(0,1).equals("r")) {
        sKaart3.setForeground(Color.RED);
      } // end of if
    } else if (slot4.equals("")) {
      sKaart4.setText(nieuweKaartWaarde.substring(1, nieuweKaartWaarde.length()));
      sKaart4.setBackground(Color.LIGHT_GRAY);
      
      if (nieuweKaartWaarde.substring(0,1).equals("h") || nieuweKaartWaarde.substring(0,1).equals("r")) {
        sKaart4.setForeground(Color.RED);
      } // end of if
    } else if (slot5.equals("")) {
      sKaart5.setText(nieuweKaartWaarde.substring(1, nieuweKaartWaarde.length()));
      sKaart5.setBackground(Color.LIGHT_GRAY);
      
      if (nieuweKaartWaarde.substring(0,1).equals("h") || nieuweKaartWaarde.substring(0,1).equals("r")) {
        sKaart5.setForeground(Color.RED);
      } // end of if
    } else if (slot6.equals("")) {
      sKaart6.setText(nieuweKaartWaarde.substring(1, nieuweKaartWaarde.length()));
      sKaart6.setBackground(Color.LIGHT_GRAY);
      
      if (nieuweKaartWaarde.substring(0,1).equals("h") || nieuweKaartWaarde.substring(0,1).equals("r")) {
        sKaart6.setForeground(Color.RED);
      } // end of if
    } else if (slot7.equals("")) {
      sKaart7.setText(nieuweKaartWaarde.substring(1, nieuweKaartWaarde.length()));
      sKaart7.setBackground(Color.LIGHT_GRAY);
      
      if (nieuweKaartWaarde.substring(0,1).equals("h") || nieuweKaartWaarde.substring(0,1).equals("r")) {
        sKaart7.setForeground(Color.RED);
      } // end of if
    }
    
    int totaal = totaalSpeler.getInt() + nieuweKaartPunten; //Totaal berekenen en invullen
    totaalSpeler.setInt(totaal);
    
    if (totaal < 22 && !slot7.equals("")) {   //Wat er gebeurt bij 7 kaarten zonder kapot te gaan
      if (split == 0) {                    //Als split niet actief is 
        DeelButton.setVisible(false);
        KaartButton.setVisible(false);
        PasButton.setVisible(false);
        SplitButton.setVisible(false);
        
        int bankPunten = kaartenBank();
        
        eindVeld.setText("Speler wint!\nDe speler heeft het spel overleefd met 7 kaarten en wint!");
        
        eindVeld.setVisible(true);
      } else if (split == 1) {           //Als de 1e kaart van split er ligt
        try {                      //Wachten                                                                 
          Thread.sleep(400);                                                                          
        } catch(Exception e) {                                                                       
          e.printStackTrace () ;                                                                    
        }
        
        split = 3; //Split op 2e kaart zetten (3 = 7 kaarten overleven)
        
        splitEersteTotaal.setInt(totaal);    //2e split kaart pakken
        splitEersteTotaal.setVisible(true);
        sKaart8.setVisible(false);
        
        String kaart = splitKaart;                                  //neerleggen
        sKaart1.setText(kaart.substring(1, kaart.length()));
        
        if (kaart.substring(0,1).equals("h") || kaart.substring(0,1).equals("r")) {    //kleur geven
          sKaart1.setForeground(Color.RED);
        } else {
          sKaart1.setForeground(Color.BLACK);
        } // end of if-else
        
        int kaart2 = random.nextInt(kaarten.length - kaartenGebruikt);   //nieuwe kaart
        String kaart2Waarde = kaarten[kaart2];
        int kaart2Length = kaart2Waarde.length();
        
        for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {    //uit het deck halen                                              
          if (i != kaart2) {                                                                        
            if (i > kaart2) {                                                                           
              kaarten[i-1] = kaarten[i];                                                            
            } // end of if                                                                          
          }                                                                                         
        } 
        
        sKaart2.setText(kaart2Waarde.substring(1, kaart2Length));      //neerleggen
        
        if (kaart2Waarde.substring(0,1).equals("h") || kaart2Waarde.substring(0,1).equals("r")) { //kleur geven
          sKaart2.setForeground(Color.RED);
        } else {
          sKaart2.setForeground(Color.BLACK);
        } // end of if-else
        
        totaalSpeler.setInt(berekenWaardeKaart(kaart.substring(1, kaart.length())) + berekenWaardeKaart(kaart2Waarde.substring(1, kaart2Length)));  //Totaal invullen
        
        //Rest van de kaarten van tafel halen
        sKaart3.setText("");
        sKaart3.setForeground(Color.BLACK);
        sKaart3.setBackground(Color.WHITE);
        
        sKaart4.setText("");
        sKaart4.setForeground(Color.BLACK);
        sKaart4.setBackground(Color.WHITE);
        
        sKaart5.setText("");
        sKaart5.setForeground(Color.BLACK);
        sKaart5.setBackground(Color.WHITE);
        
        sKaart6.setText("");
        sKaart6.setForeground(Color.BLACK);
        sKaart6.setBackground(Color.WHITE);
        
        sKaart7.setText("");
        sKaart7.setForeground(Color.BLACK);
        sKaart7.setBackground(Color.WHITE);
      } else if (split > 1) {          //Als de 2e kaart van split er ligt
        DeelButton.setVisible(false);
        KaartButton.setVisible(false);
        PasButton.setVisible(false);
        SplitButton.setVisible(false);
        
        int bankPunten = kaartenBank();
        
        if (bankPunten < 22) {
          if (bankPunten >= splitEersteTotaal.getInt() && split == 2) {                   //Eind Berichten
            eindVeld.setText("Spel 1: Verloren\nSpel 2: Gewonnen door 7 kaarten!");
          } else if (split == 3){
            eindVeld.setText("Spel 1 & 2 gewonnen door 7 kaarten!!");
          } else if (split == 4) {
            eindVeld.setText("Spel 1: Verloren\nSpel 2: Gewonnen door 7 kaarten!"); 
          } else {
            eindVeld.setText("Spel 1: Gewonnen!\nSpel 2: Gewonnen door 7 kaarten!");
          } // end of if-else
        } else {
          if (split == 2 || split == 3) {
            eindVeld.setText("Spel 1 & 2 gewonnen!");
          } else if (split == 4) {
            eindVeld.setText("Spel 1: Verloren\nSpel 2: Gewonnen door 7 kaarten!");
          }
        } // end of if-else
        eindVeld.setVisible(true);
      }
      
    } else if (totaal < 22) {
      
    } else if (totaal > 21) {   //Over de 21 punten
      if (split == 1) {  //Bij 1e split kaart
        split = 4; //Split 2e kaart (4 = Over de 21)
        
        String kaart = splitKaart;
        
        splitEersteTotaal.setInt(totaal);
        splitEersteTotaal.setVisible(true);
        sKaart8.setVisible(false);
        
        sKaart1.setText(kaart.substring(1, kaart.length()));   //2e split kaart neerleggen
        
        if (kaart.substring(0,1).equals("h") || kaart.substring(0,1).equals("r")) {   //kleur geven
          sKaart1.setForeground(Color.RED);
        } else {
          sKaart1.setForeground(Color.BLACK);
        } // end of if-else
        
        int kaart2 = random.nextInt(kaarten.length - kaartenGebruikt);    //nieuwe kaart pakken
        String kaart2Waarde = kaarten[kaart2];
        int kaart2Length = kaart2Waarde.length();
        
        for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {        //uit het dek halen                                          
          if (i != kaart2) {                                                                        
            if (i > kaart2) {                                                                          
              kaarten[i-1] = kaarten[i];                                                            
            } // end of if                                                                          
          }                                                                                         
        } 
        
        sKaart2.setText(kaart2Waarde.substring(1, kaart2Length));        //neerleggen
        
        if (kaart2Waarde.substring(0,1).equals("h") || kaart2Waarde.substring(0,1).equals("r")) {  //kleur geven
          sKaart2.setForeground(Color.RED);
        } else {
          sKaart2.setForeground(Color.BLACK);
        } // end of if-else
        
        totaalSpeler.setInt(berekenWaardeKaart(kaart.substring(1, kaart.length())) + berekenWaardeKaart(kaart2Waarde.substring(1, kaart2Length))); //Totaal invullen
        
        //Rest van de kaarten van tafel
        sKaart3.setText("");
        sKaart3.setForeground(Color.BLACK);
        sKaart3.setBackground(Color.WHITE);
        
        sKaart4.setText("");
        sKaart4.setForeground(Color.BLACK);
        sKaart4.setBackground(Color.WHITE);
        
        sKaart5.setText("");
        sKaart5.setForeground(Color.BLACK);
        sKaart5.setBackground(Color.WHITE);
        
        sKaart6.setText("");
        sKaart6.setForeground(Color.BLACK);
        sKaart6.setBackground(Color.WHITE);
        
        sKaart7.setText("");
        sKaart7.setForeground(Color.BLACK);
        sKaart7.setBackground(Color.WHITE);
      } else if (split > 1) {   //2e kaart van split
        DeelButton.setVisible(false);
        KaartButton.setVisible(false);
        PasButton.setVisible(false);
        SplitButton.setVisible(false);
        
        int bankPunten = kaartenBank();
        
        if (bankPunten < 22) {                                                 //Eind Berichten
          if (bankPunten >= splitEersteTotaal.getInt() && split == 2) {
            eindVeld.setText("Spel 1 & 2 verloren");
          } else if (split == 3){
            eindVeld.setText("Spel 1: Gewonnen door 7 kaarten!\nSpel 2: Verloren");
          } else if (split == 4) {
            eindVeld.setText("Spel 1 & 2 verloren"); 
          } else {
            eindVeld.setText("Spel 1: Gewonnen!\nSpel 2: Verloren");
          } // end of if-else
        } else {
          if (split == 2 || split == 3) {
            eindVeld.setText("Spel 1: Gewonnen\nSpel 2: Verloren");
          } else if (split == 4) {
            eindVeld.setText("Spel 1 & 2 verloren");
          }
        }
        
        eindVeld.setVisible(true);
      } else {    //Geen split
        DeelButton.setVisible(false);
        KaartButton.setVisible(false);
        PasButton.setVisible(false);
        SplitButton.setVisible(false);
         
        int bankPunten = kaartenBank();  
        
        eindVeld.setText("Verloren! Speler heeft hoger dan 21");
        eindVeld.setVisible(true);
      } // end of if-else
    }
  } // end of KaartButton_ActionPerformed
  
  public void PasButton_ActionPerformed(ActionEvent evt) {    //Passen
    Random random = new Random();
    
    if (split == 0) {                      //Bij geen split
      DeelButton.setVisible(false);
      KaartButton.setVisible(false);
      PasButton.setVisible(false);
      SplitButton.setVisible(false);
      
      int bankPunten = kaartenBank();
      
      if (totaalSpeler.getInt() > bankPunten && bankPunten < 22) {
        eindVeld.setText("Speler heeft gewonnen!");
      } else if (totaalSpeler.getInt() <= bankPunten && bankPunten < 22) {
        eindVeld.setText("Bank heeft gewonnen!");  
      } else if (bankPunten > 21) {
        eindVeld.setText("Speler heeft gewonnen!");
      }
      eindVeld.setVisible(true);
    } else if (split == 1) {    //Bij 1e kaart van split
      try {                     //wachten                                                                  
        Thread.sleep(400);                                                                           
      } catch(Exception e) {                                                                       
        e.printStackTrace () ;                                                                    
      }
      
      split = 2; //Split (2 = onder de 21 normaal)
      
      splitEersteTotaal.setInt(totaalSpeler.getInt());   //totaal opslaan
      splitEersteTotaal.setVisible(true);
      sKaart8.setVisible(false);
      
      String kaart = splitKaart;                               //neerleggen
      sKaart1.setText(kaart.substring(1, kaart.length()));
      
      if (kaart.substring(0,1).equals("h") || kaart.substring(0,1).equals("r")) {  //kleur geven
        sKaart1.setForeground(Color.RED);
      } else {
        sKaart1.setForeground(Color.BLACK);
      } // end of if-else
      
      int kaart2 = random.nextInt(kaarten.length - kaartenGebruikt);       //kaart pakken
      String kaart2Waarde = kaarten[kaart2];
      int kaart2Length = kaart2Waarde.length();
      
      for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {         //uit het dek halen                                         
        if (i != kaart2) {                                                                        
          if (i > kaart2) {                                                                           
            kaarten[i-1] = kaarten[i];                                                            
          } // end of if                                                                          
        }                                                                                         
      } 
      
      sKaart2.setText(kaart2Waarde.substring(1, kaart2Length));           //neerleggen
      
      if (kaart2Waarde.substring(0,1).equals("h") || kaart2Waarde.substring(0,1).equals("r")) {   //kleur geven
        sKaart2.setForeground(Color.RED);
      } else {
        sKaart2.setForeground(Color.BLACK);
      } // end of if-else
      
      totaalSpeler.setInt(berekenWaardeKaart(kaart.substring(1, kaart.length())) + berekenWaardeKaart(kaart2Waarde.substring(1, kaart2Length))); //totaal berekenen
      
      //rest van de kaarten van tafel
      sKaart3.setText("");
      sKaart3.setForeground(Color.BLACK);
      sKaart3.setBackground(Color.WHITE);
      
      sKaart4.setText("");
      sKaart4.setForeground(Color.BLACK);
      sKaart4.setBackground(Color.WHITE);
      
      sKaart5.setText("");
      sKaart5.setForeground(Color.BLACK);
      sKaart5.setBackground(Color.WHITE);
      
      sKaart6.setText("");
      sKaart6.setForeground(Color.BLACK);
      sKaart6.setBackground(Color.WHITE);
      
      sKaart7.setText("");
      sKaart7.setForeground(Color.BLACK);
      sKaart7.setBackground(Color.WHITE);
    } else {   //Bij 2e kaart van split
      DeelButton.setVisible(false);
      KaartButton.setVisible(false);
      PasButton.setVisible(false);
      SplitButton.setVisible(false);
      
      int bankPunten = kaartenBank();
      
      if (bankPunten < 22) {                                                                                  //Eind bericht
        if (totaalSpeler.getInt() > bankPunten && splitEersteTotaal.getInt() > bankPunten && split != 4) {
          eindVeld.setText("Spel 1 & 2 gewonnen!!");
        } else if (totaalSpeler.getInt() > bankPunten && splitEersteTotaal.getInt() <= bankPunten) {
          eindVeld.setText("Spel 1: verloren\nSpel 2: gewonnen");
        } else if (totaalSpeler.getInt() > bankPunten && split == 4) {
          eindVeld.setText("Spel 1: verloren\nSpel 2: gewonnen");
        } else if (totaalSpeler.getInt() <= bankPunten && splitEersteTotaal.getInt() > bankPunten && split != 4) {
          eindVeld.setText("Spel 1: gewonnen\nSpel 2: verloren");
        } else {
          eindVeld.setText("Spel 1 & 2 verloren");
        } // end of if-else
      } else {
        if (split != 4) {
          eindVeld.setText("Spel 1 & 2 gewonnen!!");
        } else {
          eindVeld.setText("Spel 1: verloren\nSpel 2: gewonnen");
        } // end of if-else
      } // end of if-else
      eindVeld.setVisible(true);
    } // end of if-else
    
  } // end of PasButton_ActionPerformed
  
  public void SplitButton_ActionPerformed(ActionEvent evt) {    //Splitten
    SplitButton.setVisible(false);
    splitLabel.setVisible(true);
    
    Random random = new Random();
    
    split = 1;     //Eerste split kaart
    
    int nieuwKaart = random.nextInt(kaarten.length - kaartenGebruikt);    //nieuwe kaart voor 1e split
    String nieuwKaartWaarde = kaarten[nieuwKaart];
    int nieuwKaartLength = nieuwKaartWaarde.length();
    int nieuwKaartPunten = berekenWaardeKaart(nieuwKaartWaarde.substring(1, nieuwKaartLength));
    int splitKaartPunten = berekenWaardeKaart(splitKaart.substring(1,splitKaart.length()));
    
    sKaart8.setBackground(Color.LIGHT_GRAY);                                        //2e splitkaart opzij leggen
    sKaart8.setText(splitKaart.substring(1, splitKaart.length()));
    if (splitKaart.substring(0,1).equals("h") || splitKaart.substring(0,1).equals("r")) {
      sKaart8.setForeground(Color.RED);
    }
    
    if (splitKaart.substring(1, splitKaart.length()).equals("A")) {          //Aas waarde aanpassen
      splitKaartPunten = 1;
      aasWaarde1S = aasWaarde1S - 1;
    } // end of if
    
    if (nieuwKaartPunten == 11 && sKaart1.getText().equals("A")) {           //Aas waarde aanpassen
      aasWaarde1S++;
      nieuwKaartPunten = 1;
    } // end of if
    
    for (int i = 0; i < kaarten.length - kaartenGebruikt; i++) {             //uit het dek halen                                     
      if (i != nieuwKaart) {                                                                        
        if (i > nieuwKaart) {                                                                          
          kaarten[i-1] = kaarten[i];                                                            
        } // end of if                                                                          
      }                                                                                         
    }
    
    sKaart2.setText(nieuwKaartWaarde.substring(1,nieuwKaartLength));      //neerleggen
    
    if (nieuwKaartWaarde.substring(0,1).equals("h") || nieuwKaartWaarde.substring(0,1).equals("r")) {  //kleur geven
      sKaart2.setForeground(Color.RED);
    } else {
      sKaart2.setForeground(Color.BLACK);
    }
    
    int totaal = totaalSpeler.getInt() - splitKaartPunten + nieuwKaartPunten;   //Totaal aanpassen
    totaalSpeler.setInt(totaal);
    
  } // end of SplitButton_ActionPerformed
  
  public void resetButton_ActionPerformed(ActionEvent evt) {
    System.exit(0);                                            //Window sluiten
  } // end of resetButton_ActionPerformed
  
  // end methods
  
} // end of class opdracht21
