package com.lucaaszsx.rpg.core.entities;

public class WarriorEntity extends BaseEntity {
    public WarriorEntity(String name, int strength, int health) {
        super(EntityType.WARRIOR, name, strength, health);
    }

    @Override
    public void attack(BaseEntity other, boolean specialAttack) {
        String otherType = other.getReadableType().toLowerCase();
        String thisType = this.getReadableType().toLowerCase();
        int baseDamage = this.getStrength() + (this.level * 2);

        if (specialAttack) {
            boolean isCritical = Math.random() < 0.2;
            double multiplier = isCritical ? 1.8 : 1.4;
            int totalDamage = (int) (baseDamage * multiplier);
            
            other.receiveAttack(totalDamage);
            System.out.printf(
                "O %s %s usou seu golpe QUEBRADOR DE OSSOS no %s %s! " +
                    (isCritical ? "Foi um acerto crítico! " : "") +
                    "Casou %d de dano.\n",
                thisType, this.getName(),
                otherType, other.getName(),
                totalDamage
            );
        }
        
        other.receiveAttack(baseDamage);
        System.out.printf(
            "O %s %s atacou o %s %s com sua espada, causando %d de dano.\n",
            thisType, this.getName(),
            otherType, other.getName(),
            baseDamage
        );
    }
}