
public class Personagem {

    private int ID;
    private double HP;
    private double MP;
    private double EXP;
    private double ATK;
    private double ESQUIVA;

    private double RFOGO;
    private double RGELO;
    private double RFISICA;
    private int STATUS;
    private String nome;
    Cell local = new Cell();

    private int iHP, cHP, tHP;
    private int iMP, cMP, tMP;
    private int cATK, tATK;
    private int cESQUIVA, tESQUIVA;
    private int cRFOGO, tRFOGO;
    private int cRGELO, tRGELO;
    private int cRFISICA, tRFISICA;
    private int atkFogo = 200, atkGelo = 350, atkSimples = 210, atkCruzado = 462;

    public Personagem() {

    }

    // construtor para o personagem
    public Personagem(int ID, String nome, int STATUS) {
        this.ID = ID;
        this.nome = nome;
        this.STATUS = STATUS;
        switch (ID) {
            case 1:
                Guerreiro();
                break;
            case 2:
                Mago();
                break;
            case 3:
                Ninja();
                break;
            case 4:
                Goblin();
                break;
            case 5:
                ElementalFogo();
                break;
            case 6:
                ElfoNegro();
                break;
            case 7:
                Dragao();
                break;
            case 8:
                Arqueiro();
                break;

        }

    }

    //metodo para upar
    public void Upar(double xp) {
    	this.EXP = this.EXP + xp;
        uparHP();
        uparMP();
        uparATK();
        uparESQUIVA();
        uparRFOGO();
        uparRGELO();
        uparRFISICA();
    }
   
    //criando guerreiro
    public void Guerreiro() {

        HP = 20;
        cHP = 500;
        tHP = 250;
        EXP = 10;

        MP = 0;
        cMP = 10;
        tMP = 200;

        cATK = 85;
        tATK = 200;

        cESQUIVA = 40;
        tESQUIVA = 250;

        cRFOGO = 10;
        tRFOGO = 100;

        cRGELO = 15;
        tRGELO = 100;

        cRFISICA = 46;     
        tRFISICA = 150;

        Upar(EXP);
    }

    //criando mago
    public void Mago() {

        HP = 15;
        cHP = 300;
        tHP = 200;
        EXP = 10;

        MP = 90;
        cMP = 700;
        tMP = 200;

        cATK = 40;
        tATK = 200;

        cESQUIVA = 20;
        tESQUIVA = 200;

        cRFOGO = 50;
        tRFOGO = 110;

        cRGELO = 58;
        tRGELO = 110;

        cRFISICA = 10;
        tRFISICA = 180;

        Upar(EXP);
    }

    // criando ninja
    public void Ninja() {

        HP = 21;
        cHP = 350;
        tHP = 150;
        EXP = 10;

        MP = 5;
        cMP = 20;
        tMP = 110;

        cATK = 73;
        tATK = 170;

        cESQUIVA = 65;
        tESQUIVA = 200;

        cRFOGO = 18;
        tRFOGO = 100;

        cRGELO = 19;
        tRGELO = 105;

        cRFISICA = 22;
        tRFISICA = 120;

        Upar(EXP);
    }

    //criando Arqueiro
    public void Arqueiro() {

        HP = 20;
        cHP = 350;
        tHP = 150;
        EXP = 10;

        MP = 30;
        cMP = 300;
        tMP = 120;

        cATK = 65;
        tATK = 200;

        cESQUIVA = 60;
        tESQUIVA = 200;

        cRFOGO = 25;
        tRFOGO = 100;

        cRGELO = 25;
        tRGELO = 105;

        cRFISICA = 15;
        tRFISICA = 140;

        Upar(EXP);
    }
    // criando goblin

    public void Goblin() {

        nome = "Goblin";
        HP = 10;
        cHP = 900;
        tHP = 350;
        EXP = 9;

        MP = 0;
        cMP = 10;
        tMP = 100;

        cATK = 105;
        tATK = 400;

        cESQUIVA = 10;
        tESQUIVA = 100;

        cRFOGO = 5;
        tRFOGO = 100;

        cRGELO = 5;
        tRGELO = 100;

        cRFISICA = 5;
        tRFISICA = 100;

    }

    public void ElfoNegro() {
        nome = "Elfo Negro";
        HP = 15;
        cHP = 900;
        tHP = 350;
        EXP = 10;

        MP = 10;
        cMP = 30;
        tMP = 150;

        cATK = 80;
        tATK = 400;

        cESQUIVA = 20;
        tESQUIVA = 100;

        cRFOGO = 10;
        tRFOGO = 120;

        cRGELO = 10;
        tRGELO = 120;

        cRFISICA = 10;
        tRFISICA = 500;

    }
    // criando elemental de fogo

    public void ElementalFogo() {
        nome = "Elemental de Fogo";
        HP = 90;
        cHP = 3200;
        tHP = 300;
        EXP = 11;

        MP = 0;
        cMP = 10;
        tMP = 100;

        cATK = 105;
        tATK = 400;

        cESQUIVA = 10;
        tESQUIVA = 100;

        cRFOGO = 5;
        tRFOGO = 100;

        cRGELO = 5;
        tRGELO = 100;

        cRFISICA = 5;
        tRFISICA = 100;

    }

    // criando o dragãos
    public void Dragao() {

        HP = 200;
        cHP = 10000;
        tHP = 250;
        EXP = 15;

        MP = 500;
        cMP = 8000;
        tMP = 250;

        cATK = 700;
        tATK = 400;

        cESQUIVA = 10;
        tESQUIVA = 110;

        cRFOGO = 500;
        tRFOGO = 300;

        cRGELO = 500;
        tRGELO = 300;

        cRFISICA = 800;
        tRFISICA = 290;

    }

    // metodo para upar o hp
    public void uparHP() {
        HP = ((cHP * (1 - (Math.pow(2.71, -EXP / tMP)))));
    }

    // metodo para upar o mp
    public void uparMP() {
        MP = ((cMP * (1 - (Math.pow(2.71, -EXP / tMP)))));
    }

    // metodo para upar o atk
    public void uparATK() {
        ATK = ((cATK * (1 - (Math.pow(2.71, -EXP / tATK)))));
    }

    // metodo para upar a ESQUIVA
    public void uparESQUIVA() {
        ESQUIVA = ((cESQUIVA * (1 - (Math.pow(2.71, -EXP / tESQUIVA)))));
    }

    // metodo para upar a rfogo
    public void uparRFOGO() {
        RFOGO = ((cRFOGO * (1 - (Math.pow(2.71, -EXP / tRFOGO)))));
    }

    // metodo para upar a rgelo
    public void uparRGELO() {
        RGELO = ((cRGELO * (1 - (Math.pow(2.71, -EXP / tRGELO)))));
    }

    // metodo para upar a rfisica
    public void uparRFISICA() {
        RFISICA = ((cRFISICA * (1 - (Math.pow(2.71, -EXP / tRFISICA)))));
    }

    public int getId() {
        return ID;
    }

    public Cell getLocal() {
        return local;
    }

    public void setLocal(Cell local) {
        this.local = local;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double hP) {
        HP = hP;
    }

    public double getMP() {
        return MP;
    }

    public void setMP(double mP) {
        MP = mP;
    }

    public double getATK() {
        return ATK;
    }

    public void setATK(double aTK) {
        ATK = aTK;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int sTATUS) {
        STATUS = sTATUS;
    }

    public String getNome() {
        return nome;
    }

    public int getcESQUIVA() {
		return cESQUIVA;
	}

	public void setcESQUIVA(int cESQUIVA) {
		this.cESQUIVA = cESQUIVA;
	}

	public void setNome(String nome) {
        this.nome = nome;
    }

    public double getESQUIVA() {
        return ESQUIVA;
    }

    public void setESQUIVA(double eSQUIVA) {
        ESQUIVA = eSQUIVA;
    }

    public double getRFOGO() {
        return RFOGO;
    }

    public void setRFOGO(double rFOGO) {
        RFOGO = rFOGO;
    }

    public double getRGELO() {
        return RGELO;
    }

    public void setRGELO(double rGELO) {
        RGELO = rGELO;
    }

    public double getRFISICA() {
        return RFISICA;
    }

    public void setRFISICA(double rFISICA) {
        RFISICA = rFISICA;
    }

	public int getcHP() {
		return cHP;
	}

	public void setcHP(int cHP) {
		this.cHP = cHP;
	}

	public int getcMP() {
		return cMP;
	}

	public void setcMP(int cMP) {
		this.cMP = cMP;
	}

	public double getEXP() {
		return EXP;
	}

	public void setEXP(double eXP) {
		EXP = eXP;
	}
    
	
}
