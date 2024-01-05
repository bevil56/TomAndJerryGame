package entity;

import game.GamePanel;
import graphics.Sprite;
import utils.Vector2f;
import utils.KeyHandler;
import utils.MouseHandler;

import java.awt.*;

public class Jerry extends Entity{
    public Jerry(Sprite sprite, Vector2f vector2f, int size) {
        super(sprite, vector2f, size);
        bounds.setWidth(10);
        bounds.setHeight(10);
        bounds.setYOffset(24);
        bounds.setXOffset(10);
    }
    public void move() {
//        if(up && !left && !right) {
//            dy -= acceleration;
//            if(dy < -maxSpeed) {
//                dy = -maxSpeed;
//            }
//        } else if(down && !left && !right) {
//            dy += acceleration;
//            if(dy > maxSpeed) {
//                dy = maxSpeed;
//            }
//        } else {
//            if(dy < 0) {
//                dy += deceleration;
//                if(dy > 0) {
//                    dy = 0;
//                }
//            } else if (dy > 0) {
//                dy -= deceleration;
//                if(dy < 0) {
//                    dy = 0;
//                }
//            }
//        }
//
//        if(left && !up && !down) {
//            dx -= acceleration;
//            if(dx < -maxSpeed) {
//                dx = -maxSpeed;
//            }
//        } else if(right && !up && !down) {
//            dx += acceleration;
//            if(dx > maxSpeed) {
//                dx = maxSpeed;
//            }
//        } else {
//            if(dx < 0) {
//                dx += deceleration;
//                if(dx > 0) {
//                    dx = 0;
//                }
//            } else if (dx > 0) {
//                dx -= deceleration;
//                if(dx < 0) {
//                    dx = 0;
//                }
//            }
//        }
        if (up) {
            dy -= acceleration;
            if (dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        } else if (down) {
            dy += acceleration;
            if (dy > maxSpeed) {
                dy = maxSpeed;
            }
        } else {
            if (dy < 0) {
                dy += deceleration;
                if (dy > 0) {
                    dy = 0;
                }
            } else if (dy > 0) {
                dy -= deceleration;
                if (dy < 0) {
                    dy = 0;
                }
            }
        }

        if (left) {
            dx -= acceleration;
            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else if (right) {
            dx += acceleration;
            if (dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if (dx < 0) {
                dx += deceleration;
                if (dx > 0) {
                    dx = 0;
                }
            } else if (dx > 0) {
                dx -= deceleration;
                if (dx < 0) {
                    dx = 0;
                }
            }
        }

        if (up && left || up && right || down && left || down && right) {
            dy *= diagonalFactor;
            dx *= diagonalFactor;
        }
    }
    public void update(){
        super.update();
        move();
        if(!bounds.collisionTile(dx, 0)){
            if(pos.x + dx >= 0 && pos.x + dx + bounds.getWidth() * 2 <= GamePanel.width) {
                pos.x += dx;
            }
        }

        if(!bounds.collisionTile(0, dy)){
                pos.y += dy;
        }
    }
    @Override
    public void render(Graphics2D g2D) {
        g2D.setColor(Color.BLUE);
        g2D.drawRect((int) (pos.x + bounds.getXOffset()), (int) (pos.y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
        g2D.drawImage(animation.getImage(),(int) (pos.x), (int) (pos.y), size, size, null);
    }
    public void input(MouseHandler mouse, KeyHandler key){
        up = key.up.down;
        down = key.down.down;
        left = key.left.down;
        right = key.right.down;
    }
}
