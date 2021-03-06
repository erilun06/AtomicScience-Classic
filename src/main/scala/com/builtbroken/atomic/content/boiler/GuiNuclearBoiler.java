package com.builtbroken.atomic.content.boiler;

import com.builtbroken.jlib.data.science.units.UnitDisplay;
import com.builtbroken.mc.prefab.gui.GuiContainerBase;
import com.builtbroken.mc.prefab.gui.GuiSlotType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

public class GuiNuclearBoiler extends GuiContainerBase
{
    private TileNuclearBoiler tileEntity;

    public GuiNuclearBoiler(EntityPlayer player, TileNuclearBoiler tileEntity)
    {
        super(new ContainerNuclearBoiler(player, tileEntity));
        this.tileEntity = tileEntity;
    }

    /** Draw the foreground layer for the GuiContainer (everything in front of the items) */
    @Override
    public void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        fontRendererObj.drawString(tileEntity.getInventoryName(), 52, 6, 4210752);

        this.renderUniversalDisplay(8, 112, TileNuclearBoiler.DIAN * 20, mouseX, mouseY, UnitDisplay.Unit.WATT);
        //this.renderUniversalDisplay(110, 112, this.tileEntity.getVoltageInput(null), mouseX, mouseY, Unit.VOLTAGE);

        fontRendererObj.drawString("The nuclear boiler can boil", 8, 75, 4210752);
        fontRendererObj.drawString("yellow cake into uranium", 8, 85, 4210752);
        fontRendererObj.drawString("hexafluoride gas to be refined.", 8, 95, 4210752);

        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);

        /* TODO re-add tooltips
        if (this.isPointInRegion(8, 18, this.meterWidth, this.meterHeight, mouseX, mouseY) && this.tileEntity.waterTank.getFluid() != null)
        {
            this.drawTooltip(mouseX - this.guiLeft, mouseY - this.guiTop + 10, this.tileEntity.waterTank.getFluid().getFluid().getLocalizedName(), this.tileEntity.waterTank.getFluid().amount + " L");

        }
        else if (this.isPointInRegion(155, 18, this.meterWidth, this.meterHeight, mouseX, mouseY) && this.tileEntity.gasTank.getFluid() != null)
        {
            this.drawTooltip(mouseX - this.guiLeft, mouseY - this.guiTop + 10, this.tileEntity.gasTank.getFluid().getFluid().getLocalizedName(), this.tileEntity.gasTank.getFluid().amount + " L");
        }
        */
    }

    /** Draw the background layer for the GuiContainer (everything behind the items) */
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int x, int y)
    {
        super.drawGuiContainerBackgroundLayer(par1, x, y);

        this.drawSlot(55, 25, GuiSlotType.BATTERY);
        this.drawSlot(80, 25);

        //this.drawBar(110, 26, (float) this.tileEntity.timer / (float) this.tileEntity.SHI_JIAN);

        // Water
        this.drawMeter(8, 18, (float) this.tileEntity.waterTank.getFluidAmount() / (float) this.tileEntity.waterTank.getCapacity(), this.tileEntity.waterTank.getFluid());
        this.drawSlot(24, 49, GuiSlotType.LIQUID);

        // Uranium Gas
        this.drawMeter(155, 18, (float) this.tileEntity.gasTank.getFluidAmount() / (float) this.tileEntity.gasTank.getCapacity(), this.tileEntity.gasTank.getFluid());
        this.drawSlot(135, 49, GuiSlotType.LIQUID);
    }
}