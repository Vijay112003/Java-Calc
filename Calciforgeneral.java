import java.awt.*;
import java.awt.event.*;

class MiniCalc extends Frame implements ActionListener
{
    TextField txans;
	Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,btsm,btsb,btml,btdi,bteq,btdt,btac,btc,btcp,btop;
	Label l1;
	int optop=-1,max,top=-1;
	Double[] eval=new Double[100];
	char opstack[]=new char[100];
	MiniCalc()
    {
        txans=new TextField();
		txans.setBounds(20,50,215,55);
		add(txans);
		txans.addActionListener(this);

        bt1=new Button("1");
		bt1.setBounds(20,165,50,50);
		add(bt1);
		bt1.addActionListener(this);

        bt2=new Button("2");
		bt2.setBounds(75,165,50,50);
		add(bt2);
		bt2.addActionListener(this);

        bt3=new Button("3");
		bt3.setBounds(130,165,50,50);
		add(bt3);
		bt3.addActionListener(this);

        bt4=new Button("4");
		bt4.setBounds(20,220,50,50);
		add(bt4);
		bt4.addActionListener(this);

        bt5=new Button("5");
		bt5.setBounds(75,220,50,50);
		add(bt5);
		bt5.addActionListener(this);

        bt6=new Button("6");
		bt6.setBounds(130,220,50,50);
		add(bt6);
		bt6.addActionListener(this);

        bt7=new Button("7");
		bt7.setBounds(20,275,50,50);
		add(bt7);
		bt7.addActionListener(this);

        bt8=new Button("8");
		bt8.setBounds(75,275,50,50);
		add(bt8);
		bt8.addActionListener(this);

        bt9=new Button("9");
		bt9.setBounds(130,275,50,50);
		add(bt9);
		bt9.addActionListener(this);

        bt0=new Button("0");
		bt0.setBounds(20,330,50,50);
		add(bt0);
		bt0.addActionListener(this);

        btsm=new Button("+");
		btsm.setBounds(185,165,50,50);
		add(btsm);
		btsm.addActionListener(this);

        btsb=new Button("-");
		btsb.setBounds(185,220,50,50);
		add(btsb);
		btsb.addActionListener(this);

        btml=new Button("x");
		btml.setBounds(185,275,50,50);
		add(btml);
		btml.addActionListener(this);

        btdi=new Button("/");
		btdi.setBounds(185,330,50,50);
		add(btdi);
		btdi.addActionListener(this);

        bteq=new Button("=");
		bteq.setBounds(130,330,50,50);
		add(bteq);


		bteq.addActionListener(this);

        btop=new Button("(");
		btop.setBounds(20,110,50,50);
		add(btop);
		btop.addActionListener(this);

        btcp=new Button(")");
		btcp.setBounds(75,110,50,50);
		add(btcp);
		btcp.addActionListener(this);

        btc=new Button("C");
		btc.setBounds(130,110,50,50);
		add(btc);
		btc.addActionListener(this);

        btac=new Button("AC");
		btac.setBounds(185,110,50,50);
		add(btac);
		btac.addActionListener(this);

        btdt=new Button(".");
		btdt.setBounds(75,330,50,50);
		add(btdt);
		btdt.addActionListener(this);

        setBackground(Color.DARK_GRAY);
		setSize(255,400);
		setLayout(null);
		setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e)
	{
		String query=" ",value=" ",ans=" ";
		int len;
		if(e.getSource()==bt1)
		{
			query=txans.getText();
			txans.setText(query+"1");
		}
		if(e.getSource()==bt2)
		{
			query=txans.getText();
			txans.setText(query+"2");
		}
		if(e.getSource()==bt3)
		{
			query=txans.getText();
			txans.setText(query+"3");
		}
		if(e.getSource()==bt4)
		{
			query=txans.getText();
			txans.setText(query+"4");
		}
		if(e.getSource()==bt5)
		{
			query=txans.getText();
			txans.setText(query+"5");
		}
		if(e.getSource()==bt6)
		{
			query=txans.getText();
			txans.setText(query+"6");
		}
		if(e.getSource()==bt7)
		{
			query=txans.getText();
			txans.setText(query+"7");
		}
		if(e.getSource()==bt8)
		{
			query=txans.getText();
			txans.setText(query+"8");
		}
		if(e.getSource()==bt9)
		{
			query=txans.getText();
			txans.setText(query+"9");
		}
		if(e.getSource()==bt0)
		{
			query=txans.getText();
			txans.setText(query+"0");
		}
		if(e.getSource()==btsm)
		{
			query=txans.getText();
			txans.setText(query+"+");
		}
		if(e.getSource()==btsb)
		{
			query=txans.getText();
			txans.setText(query+"-");
		}
		if(e.getSource()==btml)
		{
			query=txans.getText();
			txans.setText(query+"*");
		}
		if(e.getSource()==btdi)
		{
			query=txans.getText();
			txans.setText(query+"/");
		}
		if(e.getSource()==btdt)
		{
			query=txans.getText();
			txans.setText(query+".");
		}
		if(e.getSource()==btac)
		{
			query=txans.getText();
			txans.setText("");
		}
		if(e.getSource()==btop)
		{
			query=txans.getText();
			txans.setText(query+"(");
		}
		if(e.getSource()==btcp)
		{
			query=txans.getText();
			txans.setText(query+")");
		}
		if(e.getSource()==btc)
		{
			try {
			query=txans.getText();
			len = query.length() - 1;
			value = query.substring(0, len);
			txans.setText(value);
			}
			catch(Exception er){
				txans.setText("Empty");
			}
		}
		if(e.getSource()==bteq)
		{
			query=txans.getText();
			query=postfix(query);
			ans=postevalu(query);
			txans.setText(ans);
		}
		
	}

    public String postfix(String exp){
		int i=0;
		String post="",space=" ";
		exp=exp+"}";
		char[] arrexp=exp.toCharArray();
		while(arrexp[i]!='}')
		{
			if(arrexp[i]=='(')
			{
				push('(');
			}
			else if(arrexp[i]==')')
			{
				while((optop!=-1)&&(opstack[optop]!='('))
				{
					post=post+" "+Character.toString(pop());
				}
				char brace=pop();
			}
			else if(arrexp[i]=='+'||arrexp[i]=='-'||arrexp[i]=='*'||arrexp[i]=='/')
			{
				if(optop==-1||arrexp[i]!=')')
				{
					push(arrexp[i]);
					post=post+" ";
				}
				while((optop!=-1)&&(arrexp[i]!='(')&&(getprio(opstack[optop])>getprio(arrexp[i])))
				{
					post=post+Character.toString(pop());
				}
			}
			else
			{
				post=post+Character.toString(arrexp[i]);
			}
			i=i+1;
		}
		post=post+space.toString();
		while((optop!=-1)&&(opstack[optop]!=')'))
		{
			post=post+Character.toString(pop());
		}
		post.trim();
		post=post+Character.toString('v');
		return post;
	}
	public void push(char val) {
		optop=optop+1;
		opstack[optop]=val;
	}
	public char pop() {
		char val=' ';
		if(optop>-1)
		{
			val=opstack[optop];
			optop=optop-1;
		}
		return val;
	}
	public int getprio(char op) {
		int pri=-1;
		if(op=='/'||op=='*')
			pri=1;
		else if(op=='+'||op=='-')
			pri=0;
		return pri;
	}


	public String postevalu(String post) {
		double num1=0,num2=0,value=0;
		int i=0,j=0;
		String temp="";
		char[] postexp=post.toCharArray();
		char chtemp;
		while(postexp[i]!='v')
		{
			chtemp=postexp[i];
			if(chtemp=='.'||chtemp=='1'||chtemp=='2'||chtemp=='3'||chtemp=='4'||chtemp=='5'||chtemp=='6'||chtemp=='7'||chtemp=='8'||chtemp=='9'||chtemp=='0')
			{
				temp=temp+Character.toString(postexp[i]);
			}
			else if(chtemp==' '&&temp!="")
			{
				pushev(Double.parseDouble(temp));
				temp="";
			}
			else if(chtemp=='+'||chtemp!='-'||chtemp!='*'||chtemp!='/')
			{
				num2=popev();
				num1=popev();
				switch (postexp[i]) {
					case '+':
						value=num1+num2;
						break;
					case '-':
						value=num1-num2;
						break;
					case '*':
						value=num1*num2;
						break;
					case '/':
						value=num1/num2;
						break;
				}
				pushev(value);
			}
			i=i+1;
		}
		return Double.toString(popev());
	}
	public void pushev(double val) {
		eval[++top]=val;
	}
	public double popev(){
		double val=0;
		if(top!=-1)
		{
			val=eval[top--];
		}
		return val;
	}
	public static void main(String args[]){
		new MiniCalc();
	}
}