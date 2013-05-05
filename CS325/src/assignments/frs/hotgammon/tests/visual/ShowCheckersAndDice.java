package assignments.frs.hotgammon.tests.visual;

import minidraw.standard.*;
import minidraw.framework.*;
import javax.swing.*;
import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.tools.HotGammonTool;
import assignments.frs.hotgammon.variants.factories.BlotTestMon;
import assignments.frs.hotgammon.variants.factories.SemiMon;
import assignments.frs.hotgammon.view.HotGammonDrawing;
import assignments.frs.hotgammon.view.HotGammonTextField;

/** Show the dice and some checkers on the
 * backgammon board.  
 * 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Computer Science Department
     Aarhus University
   
   This source code is provided WITHOUT ANY WARRANTY either 
   expressed or implied. You may study, use, modify, and 
   distribute it for non-commercial purposes. For any 
   commercial use, see http://www.baerbak.com/
 */
public class ShowCheckersAndDice {
  
  public static void main(String[] args) {
    Game game=new GameImpl(new SemiMon());
    DrawingEditor editor = 
      new MiniDrawApplication( "Show HotGammon figures...",  
                               new HotGammonFactory(game) );
    editor.open();
    game.newGame();
    game.nextTurn();

    editor.setTool( new HotGammonTool(editor, game) );

  }
}

class HotGammonFactory implements Factory {
  private Game game;

public HotGammonFactory(Game game) {
		this.game=game;
	}

public DrawingView createDrawingView( DrawingEditor editor ) {
    DrawingView view = 
      new StdViewWithBackground(editor, "board");
    return view;
  }

  public Drawing createDrawing( DrawingEditor editor ) {
	HotGammonDrawing temp=new HotGammonDrawing(game);
    game.addObserver(temp);
    return temp;
    
  }

  public JTextField createStatusField( DrawingEditor editor ) {
    HotGammonTextField statusField = new HotGammonTextField( "Hello HotGammon..." );
    game.addObserver(statusField);
    statusField.setEditable(true);
    return statusField;
  }
}


