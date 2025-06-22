package com.lucaaszsx.rpg.core.entities;

public class ArcherEntity extends BaseEntity {
    public ArcherEntity(String name, int strength, int health) {
        super(EntityType.ARCHER, name, strength, health);
    }
    
    @Override
    public void attack(BaseEntity other, boolean specialAttack) {
        String otherType = other.getReadableType().toLowerCase();
        String thisType = this.getReadableType().toLowerCase();
        int baseDamage = this.getStrength() + (this.level * 2);

        if (specialAttack) {
            boolean isCritical = Math.random() < 0.25;
            double multiplier = isCritical ? 1.9 : 1.5;
            int totalDamage = (int) (baseDamage * multiplier);
            
            other.receiveAttack(totalDamage);
            System.out.printf(
                "O %s %s disparou um TIRO PERFURANTE no %s %s! " +
                    (isCritical ? "Foi um acerto crítico! " : "") +
                    "Causou %d de dano perfurante.\n",
                thisType, this.getName(),
                otherType, other.getName(),
                totalDamage
            );
            return;
        }
        
        other.receiveAttack(baseDamage);
        System.out.printf(
            "O %s %s atirou uma flecha no %s %s, causando %d de dano.\n",
            thisType, this.getName(),
            otherType, other.getName(),
            baseDamage
        );
    }
}