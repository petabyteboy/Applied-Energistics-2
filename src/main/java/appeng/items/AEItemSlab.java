package appeng.items;

import java.util.EnumSet;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import appeng.block.AEBaseSlabBlock;
import appeng.core.features.AEFeature;
import appeng.core.features.FeatureNameExtractor;
import appeng.core.features.IAEFeature;
import appeng.core.features.IFeatureHandler;
import appeng.core.features.ItemFeatureHandler;

import com.google.common.base.Optional;

public class AEItemSlab extends ItemSlab implements IAEFeature {
	
	private final String fullName;
	private final Optional<String> subName;
	private IFeatureHandler feature;
	private AEBaseSlabBlock slab;
	
	public AEItemSlab(AEBaseSlabBlock slab) {
		super(slab, slab, slab, false);
		this.slab = slab;
		this.subName = Optional.<String>absent();
		this.fullName = new FeatureNameExtractor( this.field_150939_a.getClass(), subName ).get();
	}

	@Override
	public String toString()
	{
		return this.fullName;
	}

	@Override
	public IFeatureHandler handler()
	{
		return this.feature;
	}

	@Override
	public void postInit()
	{
		// override!
	}

	public void setFeature( EnumSet<AEFeature> f )
	{
		this.feature = new ItemFeatureHandler( f, this, this, this.subName );
	}

	@Override
	@SuppressWarnings( "unchecked" )
	public final void addInformation( ItemStack stack, EntityPlayer player, List lines, boolean displayMoreInfo )
	{
		this.addCheckedInformation( stack, player, lines, displayMoreInfo );
	}

	public void addCheckedInformation( ItemStack stack, EntityPlayer player, List<String> lines, boolean displayMoreInfo )
	{
		super.addInformation( stack, player, lines, displayMoreInfo );
	}

}
