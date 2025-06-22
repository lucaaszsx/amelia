package com.lucaaszsx.rpg.core.entities;

public abstract class BaseEntity {
    protected EntityType type;
    protected String name;
    protected int strength;
    protected int health;
    protected int level;
    
    public BaseEntity(EntityType type, String name, int strength, int health) {
        this.type = type;
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.level = 1;
    }
    
    public String getReadableType() {
        switch (this.type) {
            case WARRIOR: return "Guerreiro";
            case WIZARD:  return "Mago";
            case ARCHER:  return "Arqueiro";
            default:      return "Desconhecido";
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public int getStrength() {
        return this.strength;
    }
    
    public int getLevel() {
        return this.level;
    }
    
    public boolean isAlive() {
        return this.health > 0;
    }
    
    public void showStatus() {
        System.out.println("\n|──────────────────────────────|");
        System.out.println("Variação: " + this.getReadableType());
        System.out.println("Nome: " + this.getName());
        System.out.println("Força: " + this.getStrength());
        System.out.println("Nível: " + this.getLevel());
        System.out.println("|──────────────────────────────|\n");
    }
    
    public void increaseLevel(int amount) {
        this.level = Math.max(1, this.getLevel() + amount);
    }
    
    public void receiveAttack(int damage) {
        this.health = Math.max(0, this.getHealth() - damage);
    }
    
    public abstract void attack(BaseEntity other, boolean specialAttack);
}