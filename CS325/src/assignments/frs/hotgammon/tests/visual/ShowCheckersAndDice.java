package assignments.frs.hotgammon.tests.visual;

import minidraw.standard.*;
import minidraw.framework.*;

import java.awt.*;
import javax.swing.*;

import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.tests.stub.StubGame1;
import assignments.frs.hotgammon.tools.CheckerMoveTool;
import assignments.frs.hotgammon.tools.HotGammonTool;
import assignments.frs.hotgammon.view.CheckerFigure;
import assignments.frs.hotgammon.view.DieFigure;

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
    DrawingEditor editor = 
      new MiniDrawApplication( "Show HotGammon figures...",  
                               new HotGammonFactory() );
    editor.open();
    Game game=new StubGame1();
    game.newGame();
    game.nextTurn();

    DieFigure redDie = new DieFigure("die4", new Point(216, 202));
    DieFigure blackDie = new DieFigure("die2", new Point(306, 202));
    editor.drawing().add(redDie);
    editor.drawing().add(blackDie);
    
    CheckerFigure bc = new CheckerFigure("blackchecker", new Point(21,21));
    editor.drawing().add(bc);
    CheckerFigure rc = new CheckerFigure("redchecker", new Point(507,390));
    editor.drawing().add(rc);

    editor.setTool( new HotGammonTool(editor, game) );

  }
}

class HotGammonFactory implements Factory {
  public DrawingView createDrawingView( DrawingEditor editor ) {
    DrawingView view = 
      new StdViewWithBackground(editor, "board");
    return view;
  }

  public Drawing createDrawing( DrawingEditor editor ) {
    return new StandardDrawing();
  }

  public JTextField createStatusField( DrawingEditor editor ) {
    JTextField statusField = new JTextField( "Hello HotGammon..." );
    statusField.setEditable(false);
    return statusField;
  }
}


