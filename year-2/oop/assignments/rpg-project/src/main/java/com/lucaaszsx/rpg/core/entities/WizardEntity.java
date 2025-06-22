package com.lucaaszsx.rpg.core.entities;

public class WizardEntity extends BaseEntity {
    public WizardEntity(String name, int strength, int health) {
        super(EntityType.WIZARD, name, strength, health);
    }

    @Override
    public void attack(BaseEntity other, boolean specialAttack) {
        String otherType = other.getReadableType().toLowerCase();
        String thisType = this.getReadableType().toLowerCase();
        int baseDamage = this.getStrength() + (this.level * 2);

        if (specialAttack) {
            // Incremento de ataque aleatório entre 10% e 40%
            double increase = 0.1 + (Math.random() * (0.4 - 0.1));
            int totalDamage = (int) (baseDamage * (1 + increase));
            
            other.receiveAttack(totalDamage);
            System.out.printf(
                "O %s %s conjura EXPLOSÃO ARCANA no %s %s! Dano aumentado em %d%%, causando %d de dano mágico!\n",
                thisType, this.getName(),
                otherType, other.getName(),
                (int) increase * 100,
                totalDamage
            );
        }
        
        other.receiveAttack(baseDamage);
        System.out.printf(
            "O %s %s lançou uma magia contra o %s %s, causando %d de dano.\n",
            thisType, this.getName(),
            otherType, other.getName(),
            baseDamage
        );
    }
}