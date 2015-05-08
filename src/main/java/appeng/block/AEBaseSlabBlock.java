/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2014, AlgorithmX2, All rights reserved.
 *
 * Applied Energistics 2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Applied Energistics 2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Applied Energistics 2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.block;


import java.lang.reflect.Field;
import java.util.EnumSet;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.Block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import appeng.api.AEApi;
import appeng.core.AppEng;
import appeng.core.features.AEFeature;
import appeng.core.features.IAEFeature;
import appeng.core.features.IFeatureHandler;
import appeng.core.features.SlabBlockFeatureHandler;
import appeng.transformer.AppEngCore;

import com.google.common.base.Optional;

import cpw.mods.fml.relauncher.ReflectionHelper;


public abstract class AEBaseSlabBlock extends BlockSlab implements IAEFeature
{
	private final IFeatureHandler features;
	public AEBaseBlock block;

	protected AEBaseSlabBlock( AEBaseBlock block, int meta, EnumSet<AEFeature> features )
	{
        super( true, block.getMaterial());
		this.features = new SlabBlockFeatureHandler( features, this, Optional.<String>absent() );

        this.setHardness( this.block.getBlockHardness(null, 0, 0, 0) );
        this.setResistance( this.block.getExplosionResistance(null) * 5.0F / 3.0F );
        this.setStepSound( this.block.stepSound );
		this.setBlockTextureName( this.block.getTextureName() );
	}

	@Override
	public IFeatureHandler handler()
	{
		return this.features;
	}

	@Override
	public void postInit()
	{
		// Override to do stuff
	}

	@Override
	public String func_150002_b(int p_150002_1_)
	{
		return "";
	};
}
