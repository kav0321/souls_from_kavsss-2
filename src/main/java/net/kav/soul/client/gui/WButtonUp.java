package net.kav.soul.client.gui;

import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.icon.Icon;
import io.github.cottonmc.cotton.gui.widget.icon.TextureIcon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class WButtonUp extends WButton {

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        Icon icon;
        if (this.isEnabled()) {
            boolean hovered = (mouseX >= 0 && mouseY >= 0 && mouseX < getWidth() && mouseY < getHeight());
            icon = new TextureIcon(new Identifier("soul:textures/gui/buttonup.png"));
            if (hovered) {
                icon = new TextureIcon(new Identifier("soul:textures/gui/buttonupselected.png"));
            }
        } else {
            icon = new TextureIcon(new Identifier("soul:textures/gui/buttonupdisable.png"));
        }
        icon.paint(matrices, x , y, 13);
    }

    @Override
    public void setSize(int x, int y) {
        this.width = 15;
        this.height = 10;
    }

}
