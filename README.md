# Yosoku Tatakai

Made by [pandenutella](https://github.com/pandenutella)

**For those who are interested to use this project in their groups, kindly clone the project and store it somewhere
accessible to all of your programmers/participants. Do not directly push in this GitHub project.**

## Description

Yosoku Tatakai is a fighting game program where programmers can battle using their custom-made fighters.

## Specifications

### Battle

- Can accommodate 2 fighters at a time
- Lasts for 10 rounds or until a fighter's HP reaches 0
- Each round, fighters switch roles between attackers and defenders and throw combos at the same time
- Automatically ends if a fighter breaks a  `combo` rule

### Combo

- Should have 3 moves
- Can only have the same move twice

### Fighter

- Have 100 HP
- Attacks using combos
- Counters using combos

### Move

#### Jab

- Deals 10 damage
- Cancels out `Jab`
- Interrupts `Straight`

#### Straight

- Deals 20 damage
- Cancels out `Straight`

#### Block

- Blocks 10 damage

## Preparation

Each programmer who wishes to take part in the battle should create their own fighter by following below steps:

1. Create a new branch whose name is in `Your Nickname` format.
1. Create a fighter by copying the `EmptyFighter` class under `...custom.characters` package and naming
   it `${YourNickname}Fighter` *(make sure your fighter's classname won't conflict with the other programmers')*.
2. Return your nickname in your fighter class's `getName()` method in `Your Nickname` format.
3. Return a combo in `initiateAttack()` method. You can't use the `Random()` class. *(make sure enemy fighters will have
   a hard time countering your moves)*.
4. Return a combo in `formulateCounter()` method based on your enemy's first move. You can't use the `Random()`
   class. *(make sure to cancel out all of your enemy's moves)*.
5. Implement an algorithm in `observeEnemyCounter()` that will help you initiate your next attacks.
6. Commit your changes.

## Execution

After days or weeks of preparation, the participating programmers should meet. There should be a facilitator who should
manage the battle and do the following steps:

1. Request all participants to push their changes.
2. Merge the branches of the participants in `master` and push.
3. Create a tag with the name `Battle ${sequence}` in master.
4. Decide what the format of the battles will be *(tournament style, round-robin, etc.)*.
5. Make the participants' fighters fight by using their classes to replace the values of `character1` and `character2`
   in `YosokuTatakai`
   class.

Once there is a winner among the participants, he/she will be the facilitator of the next battle session. Also, he/she
may implement some small changes in the game. 
