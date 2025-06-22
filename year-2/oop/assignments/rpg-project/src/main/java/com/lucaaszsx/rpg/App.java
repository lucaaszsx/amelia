package com.lucaaszsx.rpg;

import com.lucaaszsx.rpg.core.entities.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        BaseEntity warrior = new WarriorEntity("Thorg", 14, 100);
        BaseEntity archer = new ArcherEntity("Lyna", 12, 85);
        BaseEntity wizard = new WizardEntity("Elyon", 10, 80);
        BaseEntity[] fighters = { warrior, archer, wizard };
        
        System.out.println("⚔️ Iniciando a Arena dos Campeões...\n");
        Thread.sleep(1500);
        
        int round = 1;
        
        while (true) {
            System.out.printf("🏁 RODADA %d:\n", round++);
            BaseEntity first = null, second = null, remaining = null;
            
            int count = 0;
            
            for (BaseEntity fighter : fighters) {
                if (fighter.isAlive()) {
                    if (first == null) first = fighter;
                    else if (second == null) second = fighter;
                    count++;
                }
            }
            
            if (count == 1) {
                for (BaseEntity fighter : fighters) {
                    if (fighter.isAlive()) {
                        System.out.printf("\n🏆 O campeão é o %s %s!\n", fighter.getReadableType(), fighter.getName());
                        return;
                    }
                }
            }
            
            battle(first, second);
            Thread.sleep(2000);
        }
    }
    
    public static void battle(BaseEntity a, BaseEntity b) throws InterruptedException {
        System.out.printf("\n🔥 %s (%s) VS %s (%s) 🔥\n\n", a.getName(), a.getReadableType(), b.getName(), b.getReadableType());
        
        Thread.sleep(1000);
        
        int turn = 1;
        
        while (a.isAlive() && b.isAlive()) {
            BaseEntity attacker = (turn % 2 == 1) ? a : b;
            BaseEntity defender = (attacker == a) ? b : a;
            
            boolean useSpecial = Math.random() < 0.4;
            
            attacker.attack(defender, useSpecial);
            System.out.printf("❤️ Vida restante de %s: %d\n", defender.getName(), defender.getHealth());

            Thread.sleep(1500);
            turn++;
        }
        
        System.out.println("\n💀 Um dos combatentes caiu...\n");
        Thread.sleep(1500);
    }
}