package design_pattern.bullet;

import java.util.ArrayList;
import java.util.List;

public class Gun {
    private int bulletCount = 1000;

    public void fireInPool() {
        BulletPool bulletPool = new BulletPool();
        List<Bullet> bullets = new ArrayList<>();
        for (int i = 0; i < bulletCount; i++) {
            Bullet bullet = bulletPool.newItem();
            bullet.setPosition(0);
            bullets.add(bullet);
            for(int j = 0; j < bullets.size(); j++) {
                Bullet bullet1 = bullets.get(j);
                bullet1.move();
                System.out.print("-" + bullet1.getPosition());
                if (bullet1.getPosition() == 10) {
                    bulletPool.freeItem(bullet1);
                    bullets.remove(bullet1);
                }
            }
            System.out.println();
        }

    }

    public void fire() {
        List<Bullet> plist = new ArrayList<>();
        for(int i = 0; i < bulletCount; i++) {
            Bullet p = new Bullet();
            p.setPosition(0);
            plist.add(p);
            for (int j = 0; j < plist.size(); j++) {
                Bullet pp = plist.get(j);
                pp.move();
                System.out.print("-" + pp.getPosition());
                if (pp.getPosition() == 10) {
                    plist.remove(pp);
                }
            }
            System.out.println();
        }
    }
}
