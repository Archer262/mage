/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.cards.m;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.dynamicvalue.common.CardsInAllHandsCount;
import mage.abilities.effects.common.continuous.SetPowerToughnessSourceEffect;
import mage.abilities.keyword.ShroudAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Duration;
import mage.constants.SuperType;
import mage.constants.Zone;

/**
 *
 * @author Plopman
 */
public class MultaniMaroSorcerer extends CardImpl {

    public MultaniMaroSorcerer(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{4}{G}{G}");
        addSuperType(SuperType.LEGENDARY);
        this.subtype.add(SubType.ELEMENTAL);

        this.power = new MageInt(0);
        this.toughness = new MageInt(0);

        // Shroud
        this.addAbility(ShroudAbility.getInstance());
        
        // Multani, Maro-Sorcerer's power and toughness are each equal to the total number of cards in all players' hands.
        this.addAbility(new SimpleStaticAbility(Zone.ALL, new SetPowerToughnessSourceEffect(new CardsInAllHandsCount(), Duration.EndOfGame)));
    }

    public MultaniMaroSorcerer(final MultaniMaroSorcerer card) {
        super(card);
    }

    @Override
    public MultaniMaroSorcerer copy() {
        return new MultaniMaroSorcerer(this);
    }
}
