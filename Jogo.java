import javax.swing.JOptionPane;
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;
    public boolean turno;// Criação de variável booleana para decidir o turno (vez de jogar) da peça

    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
        turno = true;// O turno começa com true para permitir o primeiro movimento
    }
    
    public boolean getTurno(){
        return turno;// função para retornar o turno da peça
    }
    
    public void setTurno(){//Função que vai fazer a troca de turno automática, onde estiver "true", coloca "false" e se der algum erro a box de erro aparecerá
        if(getTurno()==true){
            turno = false;
        } else if (getTurno()==false){
            turno = true;
        } else {
             JOptionPane.showMessageDialog(null, "ERRO.");
        }
        
    } 
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    // Criação das peças brancas
    private void criarPecas() {
        Casa casa1 = tabuleiro.getCasa(0, 0);
        Peca peca1 = new Peca(casa1, Peca.PEDRA_BRANCA);
        
        Casa casa2 = tabuleiro.getCasa(2, 0);
        Peca peca2 = new Peca(casa2, Peca.PEDRA_BRANCA);
        
        Casa casa3 = tabuleiro.getCasa(4, 0);
        Peca peca3 = new Peca(casa3, Peca.PEDRA_BRANCA);
        
        Casa casa4 = tabuleiro.getCasa(6, 0);
        Peca peca4 = new Peca(casa4, Peca.PEDRA_BRANCA);
        
        Casa casa5 = tabuleiro.getCasa(1, 1);
        Peca peca5 = new Peca(casa5, Peca.PEDRA_BRANCA);
        
        Casa casa6 = tabuleiro.getCasa(3, 1);
        Peca peca6 = new Peca(casa6, Peca.PEDRA_BRANCA);
        
        Casa casa7 = tabuleiro.getCasa(5, 1);
        Peca peca7 = new Peca(casa7, Peca.PEDRA_BRANCA);
        
        Casa casa8 = tabuleiro.getCasa(7, 1);
        Peca peca8 = new Peca(casa8, Peca.PEDRA_BRANCA);
        
        Casa casa9 = tabuleiro.getCasa(0, 2);
        Peca peca9 = new Peca(casa9, Peca.PEDRA_BRANCA);
        
        Casa casa10 = tabuleiro.getCasa(2, 2);
        Peca peca10 = new Peca(casa10, Peca.PEDRA_BRANCA);
        
        Casa casa11 = tabuleiro.getCasa(4, 2);
        Peca peca11 = new Peca(casa11, Peca.PEDRA_BRANCA);
        
        Casa casa12 = tabuleiro.getCasa(6, 2);
        Peca peca12 = new Peca(casa12, Peca.PEDRA_BRANCA);
        
        //Criação das Pedras Vermelhas
        
        Casa casa13 = tabuleiro.getCasa(7, 7);
        Peca peca13 = new Peca(casa13, Peca.PEDRA_VERMELHA);
        
        Casa casa14 = tabuleiro.getCasa(5, 7);
        Peca peca14 = new Peca(casa14, Peca.PEDRA_VERMELHA);
        
        Casa casa15 = tabuleiro.getCasa(3, 7);
        Peca peca15 = new Peca(casa15, Peca.PEDRA_VERMELHA);
        
        Casa casa16 = tabuleiro.getCasa(1, 7);
        Peca peca16 = new Peca(casa16, Peca.PEDRA_VERMELHA);
        
        Casa casa17 = tabuleiro.getCasa(6, 6);
        Peca peca17 = new Peca(casa17, Peca.PEDRA_VERMELHA);
        
        Casa casa18 = tabuleiro.getCasa(7, 5);
        Peca peca18 = new Peca(casa18, Peca.PEDRA_VERMELHA);
        
        Casa casa19 = tabuleiro.getCasa(5, 5);
        Peca peca19 = new Peca(casa19, Peca.PEDRA_VERMELHA);
        
        Casa casa20 = tabuleiro.getCasa(4, 6);
        Peca peca20 = new Peca(casa20, Peca.PEDRA_VERMELHA);
        
        Casa casa21 = tabuleiro.getCasa(3, 5);
        Peca peca21 = new Peca(casa21, Peca.PEDRA_VERMELHA);
        
        Casa casa22 = tabuleiro.getCasa(2, 6);
        Peca peca22 = new Peca(casa22, Peca.PEDRA_VERMELHA);
        
        Casa casa23 = tabuleiro.getCasa(1, 5);
        Peca peca23 = new Peca(casa23, Peca.PEDRA_VERMELHA);
        
        Casa casa24 = tabuleiro.getCasa(0, 6);
        Peca peca24 = new Peca(casa24, Peca.PEDRA_VERMELHA);
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {//     Função que faz a movimentação da peça da origem para o destino clicado
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        
        
        if( getTurno()==true && (peca.getTipo()==0||peca.getTipo()==1) ){//Se o turno for true e a peça for branca, pedra ou dama, será a vez de movimentar ela e o movimento será permitido
            if(peca.getTipo()==0){//Condição para a pedra branca "0"
                destino = regrasPedrabranca(peca,destino,origem,origemX,origemY,destinoX,destinoY);
                peca.mover(destino);
                conversorDama(destino, peca);// Se a pedra branca parar nesse destino essa funçaõ converterá ela para dama
            } else if(peca.getTipo()==1){//Se não se a peça for uma dama
                regrasDama(peca,destino,origem,origemX,origemY,destinoX,destinoY);
                peca.mover(destino);
                 
            }
            
        } else if (getTurno()==false && (peca.getTipo()==2||peca.getTipo()==3) ){//Se o turno for falso, será a vez das pedras/damas vermelhas
            if(peca.getTipo()==2){//Condição para a pedra vermelha "2"
                destino = regrasPedravermelha(peca,destino,origem,origemX,origemY,destinoX,destinoY);
                peca.mover(destino);
                conversorDama(destino, peca);//Se a pedra vermelha parar nesse destino essa funçaõ converterá ela para dama
                
            } else if(peca.getTipo()==3){//Se não se a peça for uma dama
                regrasDama(peca,destino,origem,origemX,origemY,destinoX,destinoY);
                peca.mover(destino);
            }
            
        } else {
             JOptionPane.showMessageDialog(null, "Não é o seu turno");//Se a peças se tentar se movimentar em um turno errado, a box aparecerá
        }
        
    }
    
    /** // função que deu errada
    public void ganhador(int fx,int fy){
        fx = 0; fy = 0;// Variáveis para obter o destino final
        Casa veric = tabuleiro.getCasa(fx  , fx );
        boolean br = false;
        boolean ve = false;
        
        for(int i = 0; i>8; i++){
            for(int j = 0; j>8; j++){
                veric = tabuleiro.getCasa(i  , j );
                if(tabuleiro.getCasa(i  , j ).possuiPeca()==true){
                    if(tabuleiro.getCasa(i  , j ).getTiponacasa()==1 
                    || tabuleiro.getCasa(i  , j ).getTiponacasa()==2){
                        br = true;
                    } 
                    if (tabuleiro.getCasa(i  , j ).getTiponacasa()==3 
                    || tabuleiro.getCasa(i  , j ).getTiponacasa()==4) {
                        ve = true;
                    }
                }
            }
        }
        
        if(br==false){
            JOptionPane.showMessageDialog(null, "Vitória das vermelhas!");
        }
        if(ve==false){
            JOptionPane.showMessageDialog(null, "Vitória das brancas!");
        }
        
    }
     // função que deu errada
    public void combadaoB(int dx, int dy){
        int r = dx + 1;    //criação de variáveis para receber as casas de forma unitária
        int t = dy + 1;
        int u = dx - 1;
        int i = dy - 1;
        
        int g = dx + 1;    //criação de variáveis para receber as casas de forma unitária
        int h = dy + 1;
        int j = dx - 1;
        int k = dy - 1;
                                    
       Casa moveDC = tabuleiro.getCasa(r, t); //criação de funções para mover na direção das varíaveis combinadas, formando uma casa (criadas acima)
       Casa moveDB = tabuleiro.getCasa(r, i); //referências: DC: direita cima / DB: direita baixo/ EC: esquerda cima/ EB: esquerda baixo
       Casa moveEC = tabuleiro.getCasa(u, t);
       Casa moveEB = tabuleiro.getCasa(u, i);
    
       Casa vecDC = tabuleiro.getCasa(g, h); //criação de funções para mover na direção das varíaveis combinadas, formando uma casa (criadas acima)
       Casa vecDB = tabuleiro.getCasa(g, k); //referências: DC: direita cima / DB: direita baixo/ EC: esquerda cima/ EB: esquerda baixo
       Casa vecEC = tabuleiro.getCasa(j, h);
       Casa vecEB = tabuleiro.getCasa(j, k);
        if((moveDC.getTiponacasa()==2||moveDC.getTiponacasa()==3)
        && (vecDC.possuiPeca()==false)
        ||
        (moveDB.getTiponacasa()==2||moveDB.getTiponacasa()==3)
        && (vecDB.possuiPeca()==false)
        ||
        (moveEC.getTiponacasa()==2||moveEC.getTiponacasa()==3)
        && (vecEC.possuiPeca()==false)
        ||
        (moveEB.getTiponacasa()==2||moveEB.getTiponacasa()==3)
        && (vecEB.possuiPeca()==false)){
            
            reagir(CasaGUI casaClicada);
        }
    }
    **/
    
    //
    //função geral para conversão de pedra para dama
    public void conversorDama(Casa dest, Peca peca){
        if(peca.getTipo()==0){
            if((dest==tabuleiro.getCasa(7, 7)) || (dest==tabuleiro.getCasa(5, 7))// Se o destino for essas casas selecionadas, que são as casas de inicio das peças opostas
            ||(dest==tabuleiro.getCasa(3, 7)) || (dest==tabuleiro.getCasa(1, 7))){// a peça irá ser promovida a dama
                peca.setTipo();// função que muda o tipo da peça de (0) Pedra para (1) Dama.
            }
        } else if(peca.getTipo()==2){
            if((dest==tabuleiro.getCasa(6, 0)) || (dest==tabuleiro.getCasa(4, 0))// Se o destino for essas casas selecionadas, que são as casas de inicio das peças opostas
            ||(dest==tabuleiro.getCasa(2, 0)) || (dest==tabuleiro.getCasa(0, 0))){// a peça irá ser promovida a dama
                peca.setTipo();// função que muda o tipo da peça de (2) Pedra para (3) Dama.
            }
        }
    }
    
    
    // função para criação das regras das pedras brancas
    public Casa regrasPedrabranca(Peca peca, Casa destino, Casa origem, int ox, int oy, int dx, int dy){
        int fx = ox; int fy = oy;// Variáveis para obter o destino final
        Casa fnl = tabuleiro.getCasa(fx  , fy );// casa criada para ser igualada com o destino final

        if( peca.getTipo()==0 && destino.possuiPeca()==false // movimento de uma casa
           && ((dx==ox+1&&dy==oy+1)||(dx==ox-1&&dy==oy+1))){
            fx = dx;//variável de posição
            fy = dy;//variável de posição
            setTurno();
        } else 
        if(peca.getTipo()==0 && destino.possuiPeca()==false // movimento de captura(2 casas +captura)
        
            && ((dx==ox+2&&dy==oy+2)||(dx==ox-2&&dy==oy+2))
            ||((dx==ox-2&&dy==oy-2)||(dx==ox+2&&dy==oy-2)) ) {
                    int r = ox + 1;    //variáveis para a criação da casa a ser capturada
                    int t = oy + 1;
                    int u = ox - 1;
                    int i = oy - 1;
  
                     //criação de funções para mover na direção das varíaveis combinadas, formando uma casa (criadas acima)
                     //referências: DC: direita cima / DB: direita baixo/ EC: esquerda cima/ EB: esquerda baixo
        
                    if(dx==ox+2&&dy==oy+2) {
                        Casa moveDC = tabuleiro.getCasa(r, t);
                        if ( moveDC.possuiPeca()==true &&(moveDC.getTiponacasa()==2||moveDC.getTiponacasa()==3) ){// e ela for para DC e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                            moveDC.removerPeca();
                            fx = dx;
                            fy = dy;
                            setTurno();
                        } else{
                            fnl = origem;
                            JOptionPane.showMessageDialog(null,"Movimento Invalido!");// Se a condição não acontecer, aparecerá essa box
                        }                
                    } else if (dx==ox+2&&dy==oy-2) {
                        Casa moveDB = tabuleiro.getCasa(r, i);
                        if( moveDB.possuiPeca()==true
                            &&(moveDB.getTiponacasa()==2||moveDB.getTiponacasa()==3) ){// e ela for para DB e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                            moveDB.removerPeca();
                            fx = dx;
                            fy = dy;
                            setTurno();
                        }  else{
                            fnl = origem;
                            JOptionPane.showMessageDialog(null,"Movimento Invalido!");// Se a condição não acontecer, aparecerá essa box
                        }                      
                    } else if (dx==ox-2&&dy==oy+2) {
                        Casa moveEC = tabuleiro.getCasa(u, t);
                        if( moveEC.possuiPeca()==true
                        &&(moveEC.getTiponacasa()==2||moveEC.getTiponacasa()==3) ){// e ela for para EC e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                            moveEC.removerPeca();
                            fx = dx;
                            fy = dy;
                            setTurno();
                        } else{
                            fnl = origem;
                            JOptionPane.showMessageDialog(null,"Movimento Invalido!");// Se a condição não acontecer, aparecerá essa box
                        }                   
                    } else if(dx==ox-2&&dy==oy-2) {
                        Casa moveEB = tabuleiro.getCasa(u, i);
                        if( moveEB.possuiPeca()==true
                        &&(moveEB.getTiponacasa()==2||moveEB.getTiponacasa()==3) ){// e ela for para EB e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                            moveEB.removerPeca();
                            fx = dx;
                            fy = dy;
                            setTurno();
                        }else{
                            fnl = origem;
                            JOptionPane.showMessageDialog(null,"Movimento Invalido!");// Se a condição não acontecer, aparecerá essa box
                        }                
                    } else{
                        fnl = origem;
                        JOptionPane.showMessageDialog(null,"Movimento Invalido!");// Se a condição não acontecer, aparecerá essa box
                    }
        
        } else{
             fnl = origem;
             JOptionPane.showMessageDialog(null, "Movimento invalido!");
             
        }
        
        fnl = tabuleiro.getCasa(fx, fy);
        return fnl;
    }
    
    public Casa regrasPedravermelha(Peca peca, Casa destino, Casa origem, int ox, int oy, int dx, int dy){
        int fx = ox; int fy = oy;
        Casa fnl = tabuleiro.getCasa(fx, fy);
        if( peca.getTipo()==2 && destino.possuiPeca()==false && ((dx==ox-1&&dy==oy-1)||(dx==ox+1&&dy==oy-1))){
            fx = dx;
            fy = dy;
            setTurno();
        } else 
        if(peca.getTipo()==2 && destino.possuiPeca()==false 
        
            && ((dx==ox+2&&dy==oy+2)||(dx==ox-2&&dy==oy+2))
            ||((dx==ox-2&&dy==oy-2)||(dx==ox+2&&dy==oy-2)) ) {
                    boolean jj = true;
                
                    int r = ox + 1;    //criação de variáveis para receber as casas de forma unitária
                    int t = oy + 1;
                    int u = ox - 1;
                    int i = oy - 1;
                                    
                    if(dx==ox+2&&dy==oy+2) {
                        Casa moveDC = tabuleiro.getCasa(r, t);
                        if ( moveDC.possuiPeca()==true 
                        &&(moveDC.getTiponacasa()==0||moveDC.getTiponacasa()==1) ){// e ela for para DC e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                            moveDC.removerPeca();
                            fx = dx;
                            fy = dy;
                            setTurno();
                        }else{
                        fnl = origem;
                        JOptionPane.showMessageDialog(null,"Movimento Invalido!");// Se a condição não acontecer, aparecerá essa box
                        }                
                    } else if (dx==ox+2&&dy==oy-2) {
                        Casa moveDB = tabuleiro.getCasa(r, i);
                        if( moveDB.possuiPeca()==true
                            &&(moveDB.getTiponacasa()==0||moveDB.getTiponacasa()==1) ){// e ela for para DB e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                            moveDB.removerPeca();
                            fx = dx;
                            fy = dy;
                            setTurno();
                        } else{
                        fnl = origem;
                        JOptionPane.showMessageDialog(null,"Movimento Invalido!");// Se a condição não acontecer, aparecerá essa box
                        }                      
                    } else if (dx==ox-2&&dy==oy+2) {
                        Casa moveEC = tabuleiro.getCasa(u, t);
                        if( moveEC.possuiPeca()==true
                        &&(moveEC.getTiponacasa()==0||moveEC.getTiponacasa()==1) ){// e ela for para EC e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                            moveEC.removerPeca();
                            fx = dx;
                            fy = dy;
                            setTurno();
                        } else{
                        fnl = origem;
                        JOptionPane.showMessageDialog(null,"Movimento Invalido!");// Se a condição não acontecer, aparecerá essa box
                        }                  
                    } else if(dx==ox-2&&dy==oy-2) {
                        Casa moveEB = tabuleiro.getCasa(u, i);
                        if( moveEB.possuiPeca()==true
                        &&(moveEB.getTiponacasa()==0||moveEB.getTiponacasa()==1) ){// e ela for para EB e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                            moveEB.removerPeca();
                            fx = dx;
                            fy = dy;
                            setTurno();
                        }else{
                        fnl = origem;
                        JOptionPane.showMessageDialog(null,"Movimento Invalido!");// Se a condição não acontecer, aparecerá essa box
                        }              
                    } else{
                        fnl = origem;
                        JOptionPane.showMessageDialog(null,"Movimento Invalido!");// Se a condição não acontecer, aparecerá essa box
                    }
        } else {
             fnl = origem;
             JOptionPane.showMessageDialog(null, "Movimento invalido!");
        }
        
        fnl = tabuleiro.getCasa(fx, fy);
        return fnl;
    }
    
    public Casa regrasDama(Peca peca, Casa destino, Casa origem, int ox, int oy, int dx, int dy){
        int fx = ox; int fy = oy;
        Casa fnl = tabuleiro.getCasa(fx  , fy );
        
        if( peca.getTipo()==1 && destino.possuiPeca()==false 
        && (dx<ox || dy<oy || dx>ox || dy>oy) ){
            
            int r = dx - 1;    //criação de variáveis para receber as casas de forma unitária
            int t = dy - 1;
            int u = dx + 1;
            int i = dy + 1;

             //criação de funções para mover na direção das varíaveis combinadas, formando uma casa (criadas acima)
             //referências: DC: direita cima / DB: direita baixo/ EC: esquerda cima/ EB: esquerda baixo

            if(dx>ox+2&&dy>oy) {
                Casa moveDC = tabuleiro.getCasa(r, t);
                if ( moveDC.possuiPeca()==true &&(moveDC.getTiponacasa()==2||moveDC.getTiponacasa()==3) ){// e ela for para DC e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                    moveDC.removerPeca();
                    fx = dx;
                    fy = dy;
                    setTurno();
                } else if (dx>ox&&dy>oy) {
                    fx = dx;
                    fy = dy;
                    setTurno();
                }else {
                    JOptionPane.showMessageDialog(null,"Movimento Invalido!");
                    fnl = origem;
                }
                //
            } else if (dx>ox&&dy<oy) {
                Casa moveDB = tabuleiro.getCasa(r, i);
                if( moveDB.possuiPeca()==true
                    &&(moveDB.getTiponacasa()==2||moveDB.getTiponacasa()==3) ){// e ela for para DB e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                    moveDB.removerPeca();
                    fx = dx;
                    fy = dy;
                    setTurno();
                } else if (dx>ox&&dy<oy) {
                   
                    fx = dx;
                    fy = dy;
                    setTurno();
                }else {
                    JOptionPane.showMessageDialog(null,"Movimento Invalido!");
                    fnl = origem;
                } 
                //
            } else if (dx<ox&&dy<oy) {
                Casa moveEB = tabuleiro.getCasa(u, t);
                if( moveEB.possuiPeca()==true
                &&(moveEB.getTiponacasa()==2||moveEB.getTiponacasa()==3) ){// e ela for para EB e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                    moveEB.removerPeca();
                    fx = dx;
                    fy = dy;
                    setTurno();
                } else if (dx<ox&&dy<oy) {
                    
                    fx = dx;
                    fy = dy;
                    setTurno();
                }else {
                   JOptionPane.showMessageDialog(null,"Movimento Invalido!");
                    fnl = origem;
                } 
                //
            } else if(dx<ox&&dy>oy) {
                Casa moveEC = tabuleiro.getCasa(u, i);
                if( moveEC.possuiPeca()==true
                &&(moveEC.getTiponacasa()==2||moveEC.getTiponacasa()==3) ){// e ela for para DC e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                    moveEC.removerPeca();
                    fx = dx;
                    fy = dy;
                    setTurno();
                }else if (dx<ox&&dy>oy) {
                    
                    fx = dx;
                    fy = dy;
                    setTurno();
                }else {
                    JOptionPane.showMessageDialog(null,"Movimento Invalido!");
                    fnl = origem;
                }                 
            } else{
                JOptionPane.showMessageDialog(null,"Movimento Invalido!");
                fnl = origem;
            }
        
        } else if( peca.getTipo()==3 && destino.possuiPeca()==false 
                 && (dx<ox || dy<oy || dx>ox || dy>oy) ){
            int r = dx - 1;    //criação de variáveis para receber as casas de forma unitária
            int t = dy - 1;
            int u = dx + 1;
            int i = dy + 1;

             //criação de funções para mover na direção das varíaveis combinadas, formando uma casa (criadas acima)
             //referências: DC: direita cima / DB: direita baixo/ EC: esquerda cima/ EB: esquerda baixo

            if(dx>ox&&dy>oy) {
                Casa moveDC = tabuleiro.getCasa(r, t);
                if ( moveDC.possuiPeca()==true &&(moveDC.getTiponacasa()==0||moveDC.getTiponacasa()==1) ){// e ela for para DC e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                    moveDC.removerPeca();
                    fx = dx;
                    fy = dy;
                    setTurno();
                } else if (dx>ox&&dy>oy) {
                    
                    fx = dx;
                    fy = dy;
                    setTurno();
                }else {
                    JOptionPane.showMessageDialog(null,"Movimento Invalido!");
                    fnl = origem;
                }
                //
            } else if (dx>ox&&dy<oy) {
                Casa moveDB = tabuleiro.getCasa(r, i);
                if( moveDB.possuiPeca()==true
                    &&(moveDB.getTiponacasa()==0||moveDB.getTiponacasa()==1) ){// e ela for para DB e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                    moveDB.removerPeca();
                    fx = dx;
                    fy = dy;
                    setTurno();
                } else if (dx>ox&&dy<oy) {
                    
                    fx = dx;
                    fy = dy;
                    setTurno();
                }else {
                    JOptionPane.showMessageDialog(null,"Movimento Invalido!");
                    fnl = origem;
                } 
                //
            } else if (dx<ox&&dy<oy) {
                Casa moveEB = tabuleiro.getCasa(u, t);
                if( moveEB.possuiPeca()==true
                &&(moveEB.getTiponacasa()==0||moveEB.getTiponacasa()==1) ){// e ela for para EB e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                    moveEB.removerPeca();
                    fx = dx;
                    fy = dy;
                    setTurno();
                } else if (dx<ox&&dy<oy) {
                    
                    fx = dx;
                    fy = dy;
                    setTurno();
                }else {
                    JOptionPane.showMessageDialog(null,"Movimento Invalido!");
                    fnl = origem;
                } 
                //
            } else if(dx<ox&&dy>oy) {
                Casa moveEC = tabuleiro.getCasa(u, i);
                if( moveEC.possuiPeca()==true
                &&(moveEC.getTiponacasa()==0||moveEC.getTiponacasa()==1) ){// e ela for para EC e tiver peça nessa casa e o tipo da éça for pedra vermelha ou dama vermelha
                    moveEC.removerPeca();
                    fx = dx;
                    fy = dy;
                    setTurno();
                }else if (dx<ox&&dy>oy) {
                    fx = dx;
                    fy = dy;
                    setTurno();
                }else {
                    JOptionPane.showMessageDialog(null,"Movimento Invalido!");
                    fnl = origem;
                }                 
            } else{
                JOptionPane.showMessageDialog(null,"Movimento Invalido!");
                fnl = origem;
            }
        } else{
            JOptionPane.showMessageDialog(null,"Movimento Invalido!");
            fnl = origem;
        }
        
        fnl = tabuleiro.getCasa(fx, fy);
        return fnl;
    }
}
