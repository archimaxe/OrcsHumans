public class Orc extends Player{
    public static final int FOLLOW_PROBABILITY = 10;    //вероятность выбора наставника
    public static final int RAGE_COEF = 2;               //коэф-т усиления атаки после смерти наставника

    protected Orc battleLeader;

    public Orc (String name, int health, int hitPoints){
        super(name, health, hitPoints);
    }
    public void follow(Orc orc){
        //перенимаем опыт
        if (battleLeader == null && prob(FOLLOW_PROBABILITY)){
            this.battleLeader = orc;
            System.out.println(this + " стал последователем " + orc);
        }
    }
    public void hit (Human human){
        //будем бить людей
        //если есть наставник и он умер
        if (battleLeader != null && !battleLeader.isAlive()){
            System.out.println(this + " RAAAAGEEEEE " + human);
            human.decreaseHealth(RAGE_COEF*hitPoints);
            //убиарем наставника чтобы усиление атаки было разовым
            battleLeader = null;
        } else {
            System.out.println(this + " vs " + human);
            human.decreaseHealth(hitPoints);
        }
    }
    @Override
    public String toString(){
        return "Орда " + super.toString();
    }
}
