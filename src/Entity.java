public class Entity {
  public int baseHP, hpChange = 0, baseAttack, attack, bonusAttack, baseAP, currentExtraAP, nextExtraAP, blockStacks, money, xp;

  public String name;

  public Entity() {
  }

  //getters
  protected int getBaseHP() {
    return baseHP;
  }
  protected int getHP() {
    return baseHP+hpChange;
  }
  protected int getBaseAttack() {
    return baseAttack;
  }
  protected int getAttack() {
    return baseAttack+bonusAttack;
  }
  protected int getBaseAP() {
    return baseAP;
  }
  protected int getAP() {
    return baseAP+currentExtraAP;
  }
  protected int getCurrentExtraAP() {
    return currentExtraAP;
  }
  protected int getNextExtraAP() {
    return nextExtraAP;
  }
  protected int getBlockStacks() {
    return blockStacks;
  }
  protected int getMoney() {
    return money;
  }
  protected int getXP() {
    return xp;
  }
  protected String getName() {
    return name;
  }

  //changers
  protected void changeBaseHP(int baseHPChange) {
    baseHP += baseHPChange;
  }
  protected void changeBaseAttack(int baseAttackChange) {
    baseAttack += baseAttackChange;
  }
  protected void changeBaseAP(int baseAPChange) {
    baseAP += baseAPChange;
  }
  protected void changeAttack(int attackChange) {
    baseAttack += attackChange;
  }
  protected void changeAP(int APChange) {
    baseAP += APChange;
  }
  protected void changeMoney(int moneyChange) {
    money += moneyChange;
  }
  protected void changeXP(int XPChange) {
    xp += XPChange;
  }

  //resetters and setters
  protected void resetHPChange() {
    hpChange = 0;
  }
  protected void changeHP(int changeInHP) {
    hpChange += changeInHP;
  }
  protected void changeBonusAttack(int bonusAttackChange) {
    bonusAttack += bonusAttackChange;
  }
  protected void addBlockStack() {
    blockStacks++;
  }
  protected void setCurrentExtraAP() {
    currentExtraAP = nextExtraAP;
    nextExtraAP = 0;
  }
  protected void addNextExtraAP() {
    nextExtraAP++;
  }
  protected void resetBlockStacks() {
    blockStacks = 0;
  }
  protected void resetBonusAttack() {
    bonusAttack = 0;
  }
  protected void resetToBaseAP() {
    currentExtraAP = 0;
    nextExtraAP = 0;
  }
}