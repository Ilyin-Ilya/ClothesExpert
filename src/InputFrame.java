import entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.util.ArrayList;

public class InputFrame extends Frame {
    private Choice weather;
    private Choice location;
    private Choice activity_type;
    private Button get_result;
    private DBUtils utils;
    List result;

    public InputFrame(String title) {
        super(title);
        utils = new DBUtils();
        try {
            Connection con = utils.setConnection();

            this.setSize(1000, 600);
            this.setLocation(0, 0);
            this.setVisible(true);
            this.setLayout(new FlowLayout());


            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });


            //filling choices
            activity_type = new Choice();
            ArrayList<ActivityType> activityTypes = utils.getAllActivityTypes(con);
            for (ActivityType type :
                    activityTypes) {
                activity_type.add(type.getActivity_type_name());
            }

            weather = new Choice();
            ArrayList<WeatherType> weathers = utils.getAllWeatherTypes(con);
            for (WeatherType weatherType :
                    weathers) {
                weather.add(weatherType.getType_name());
            }

            location = new Choice();
            ArrayList<ActivityLocation> locationType = utils.getAllLocations(con);
            for (ActivityLocation type :
                    locationType) {
                location.add(type.getLocation_name());
            }

            this.add(activity_type);
            this.add(weather);
            this.add(location);
            get_result = new Button("Look for clothes");
            result = new List();
            get_result.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    result.removeAll();
                    ArrayList<ClothesType> clothesTypes = utils.getAllClothesTypes(con);
                    if (weather.getSelectedItem().equals("drizzle")) {
                        ClothesType rainbow = utils.findClothesTypeByName(clothesTypes, "rainbow");
                        ArrayList<ItemOfClothing> rainbows = utils.getItemOfClothingWithType(con, rainbow);
                        if (rainbows.size() != 0) {
                            result.add(rainbows.get(0).getItem_producer_name() + " rainbow");
                        }
                        if (location.getSelectedItem().equals("office") || location.getSelectedItem().equals("theater")) {
                            ClothesType golf = utils.findClothesTypeByName(clothesTypes, "golf");
                            ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "formal pants");
                            ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                            ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, formal_pants);
                            if (golfs.size() == 0) {
                                golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                                golfs = utils.getItemOfClothingWithType(con, golf);
                            }

                            if (pants.size() == 0) {
                                formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                                pants = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs.size() != 0 && pants.size() != 0) {
                                result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                            }
                        }
                        if (location.getSelectedItem().equals("gym") && activity_type.getSelectedItem().equals("very active")) {
                            ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                            ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                            ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                            if (golfs.size() == 0) {
                                golf = utils.findClothesTypeByName(clothesTypes, "golf");
                                golfs = utils.getItemOfClothingWithType(con, golf);
                            }

                            if (pants.size() == 0) {
                                formal_pants = utils.findClothesTypeByName(clothesTypes, "formal pants");
                                pants = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs.size() != 0 && pants.size() != 0) {
                                result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                            }

                            ClothesType golf2 = utils.findClothesTypeByName(clothesTypes, "sports tank");
                            ArrayList<ItemOfClothing> golfs2 = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants2 = utils.findClothesTypeByName(clothesTypes, "sports short");
                            ArrayList<ItemOfClothing> pants2 = utils.getItemOfClothingWithType(con, golf);
                            if (golfs2.size() == 0) {
                                golf2 = utils.findClothesTypeByName(clothesTypes, "sports T-shirt");
                                golfs2 = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs2.size() != 0 && pants.size() != 0) {
                                result.add(golfs2.get(0).getItem_producer_name() + " " + golf2.getType_name());
                                result.add(pants2.get(0).getItem_producer_name() + " " + formal_pants2.getType_name());
                            }

                        }
                        if (location.getSelectedItem().equals("gym") && activity_type.getSelectedItem().equals("active")) {
                            ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                            ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                            ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                            if (golfs.size() == 0) {
                                golf = utils.findClothesTypeByName(clothesTypes, "golf");
                                golfs = utils.getItemOfClothingWithType(con, golf);
                            }

                            if (pants.size() == 0) {
                                formal_pants = utils.findClothesTypeByName(clothesTypes, "formal pants");
                                pants = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs.size() != 0 && pants.size() != 0) {
                                result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                            }
                            ClothesType golf2 = utils.findClothesTypeByName(clothesTypes, "sports T-shirt");
                            ArrayList<ItemOfClothing> golfs2 = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants2 = utils.findClothesTypeByName(clothesTypes, "sports short");
                            ArrayList<ItemOfClothing> pants2 = utils.getItemOfClothingWithType(con, golf);
                            if (golfs2.size() == 0) {
                                golf2 = utils.findClothesTypeByName(clothesTypes, "sports tank");
                                golfs2 = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs2.size() != 0 && pants.size() != 0) {
                                result.add(golfs2.get(0).getItem_producer_name() + " " + golf2.getType_name());
                                result.add(pants2.get(0).getItem_producer_name() + " " + formal_pants2.getType_name());
                            }
                        } else if (location.getSelectedItem().equals("forest")) {
                            ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                            ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                            ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                            if (golfs.size() == 0) {
                                golf = utils.findClothesTypeByName(clothesTypes, "golf");
                                golfs = utils.getItemOfClothingWithType(con, golf);
                            }

                            if (pants.size() == 0) {
                                formal_pants = utils.findClothesTypeByName(clothesTypes, "formal pants");
                                pants = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (pants.size() != 0 && golfs.size() != 0) {
                                result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                            }
                        } else if (location.getSelectedItem().equals("beach")) {
                            ClothesType swim_trunk = utils.findClothesTypeByName(clothesTypes, "swim trunk");
                            ArrayList<ItemOfClothing> swim_trunks = utils.getItemOfClothingWithType(con, swim_trunk);

                            if (swim_trunks.size() != 0)
                                result.add(swim_trunks.get(0).getItem_producer_name() + " " + swim_trunk.getType_name());

                            ClothesType cap = utils.findClothesTypeByName(clothesTypes, "cap");
                            ArrayList<ItemOfClothing> caps = utils.getItemOfClothingWithType(con, cap);

                            if (caps.size() != 0)
                                result.add(caps.get(0).getItem_producer_name() + " " + cap.getType_name());

                            ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                            ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                            ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                            if (golfs.size() == 0) {
                                golf = utils.findClothesTypeByName(clothesTypes, "golf");
                                golfs = utils.getItemOfClothingWithType(con, golf);
                            }

                            if (pants.size() == 0) {
                                formal_pants = utils.findClothesTypeByName(clothesTypes, "formal pants");
                                pants = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs.size() != 0 && pants.size() != 0) {
                                result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                            }

                            ClothesType golf2 = utils.findClothesTypeByName(clothesTypes, "sports tank");
                            ArrayList<ItemOfClothing> golfs2 = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants2 = utils.findClothesTypeByName(clothesTypes, "sports short");
                            ArrayList<ItemOfClothing> pants2 = utils.getItemOfClothingWithType(con, golf);
                            if (golfs2.size() == 0) {
                                golf2 = utils.findClothesTypeByName(clothesTypes, "sports T-shirt");
                                golfs2 = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs2.size() != 0 && pants.size() != 0) {
                                result.add(golfs2.get(0).getItem_producer_name() + " " + golf2.getType_name());
                                result.add(pants2.get(0).getItem_producer_name() + " " + formal_pants2.getType_name());
                            }
                        }
                    }


                    if (weather.getSelectedItem().equals("snowy")) {

                        ClothesType coat = utils.findClothesTypeByName(clothesTypes, "winter coat");
                        ArrayList<ItemOfClothing> coats = utils.getItemOfClothingWithType(con, coat);
                        if (coats.size() != 0) {
                            result.add(coats.get(0).getItem_producer_name() + " winter coat");
                        }
                        ClothesType hat = utils.findClothesTypeByName(clothesTypes, "hat");
                        ArrayList<ItemOfClothing> hats = utils.getItemOfClothingWithType(con, hat);

                        if (hats.size() != 0) {
                            result.add(coats.get(0).getItem_producer_name() + " hat");
                        }

                        if (location.getSelectedItem().equals("office") || location.getSelectedItem().equals("theater")) {
                            ClothesType golf = utils.findClothesTypeByName(clothesTypes, "golf");
                            ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "formal pants");
                            ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                            ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, formal_pants);
                            if (golfs.size() == 0) {
                                golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                                golfs = utils.getItemOfClothingWithType(con, golf);
                            }

                            if (pants.size() == 0) {
                                formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                                pants = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs.size() != 0 && pants.size() != 0) {
                                result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                            }
                        }
                        if (location.getSelectedItem().equals("gym") && activity_type.getSelectedItem().equals("very active")) {
                            ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                            ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                            ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                            if (golfs.size() == 0) {
                                golf = utils.findClothesTypeByName(clothesTypes, "golf");
                                golfs = utils.getItemOfClothingWithType(con, golf);
                            }

                            if (pants.size() == 0) {
                                formal_pants = utils.findClothesTypeByName(clothesTypes, "formal pants");
                                pants = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs.size() != 0 && pants.size() != 0) {
                                result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                            }

                            ClothesType golf2 = utils.findClothesTypeByName(clothesTypes, "sports tank");
                            ArrayList<ItemOfClothing> golfs2 = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants2 = utils.findClothesTypeByName(clothesTypes, "sports short");
                            ArrayList<ItemOfClothing> pants2 = utils.getItemOfClothingWithType(con, golf);
                            if (golfs2.size() == 0) {
                                golf2 = utils.findClothesTypeByName(clothesTypes, "sports T-shirt");
                                golfs2 = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs2.size() != 0 && pants.size() != 0) {
                                result.add(golfs2.get(0).getItem_producer_name() + " " + golf2.getType_name());
                                result.add(pants2.get(0).getItem_producer_name() + " " + formal_pants2.getType_name());
                            }

                        }
                        if (location.getSelectedItem().equals("gym") && activity_type.getSelectedItem().equals("active")) {
                            ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                            ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                            ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                            if (golfs.size() == 0) {
                                golf = utils.findClothesTypeByName(clothesTypes, "golf");
                                golfs = utils.getItemOfClothingWithType(con, golf);
                            }

                            if (pants.size() == 0) {
                                formal_pants = utils.findClothesTypeByName(clothesTypes, "formal pants");
                                pants = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs.size() != 0 && pants.size() != 0) {
                                result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                            }
                            ClothesType golf2 = utils.findClothesTypeByName(clothesTypes, "sports T-shirt");
                            ArrayList<ItemOfClothing> golfs2 = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants2 = utils.findClothesTypeByName(clothesTypes, "sports short");
                            ArrayList<ItemOfClothing> pants2 = utils.getItemOfClothingWithType(con, golf);
                            if (golfs2.size() == 0) {
                                golf2 = utils.findClothesTypeByName(clothesTypes, "sports tank");
                                golfs2 = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (golfs2.size() != 0 && pants.size() != 0) {
                                result.add(golfs2.get(0).getItem_producer_name() + " " + golf2.getType_name());
                                result.add(pants2.get(0).getItem_producer_name() + " " + formal_pants2.getType_name());
                            }
                        } else if (location.getSelectedItem().equals("forest") || location.getSelectedItem().equals("beach")) {
                            ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                            ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                            ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                            ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                            if (golfs.size() == 0) {
                                golf = utils.findClothesTypeByName(clothesTypes, "golf");
                                golfs = utils.getItemOfClothingWithType(con, golf);
                            }

                            if (pants.size() == 0) {
                                formal_pants = utils.findClothesTypeByName(clothesTypes, "formal pants");
                                pants = utils.getItemOfClothingWithType(con, golf);
                            }
                            if (pants.size() != 0 && golfs.size() != 0) {
                                result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                            }
                        }
                    }

                    if (weather.getSelectedItem().equals("sunny")) {
                        if (location.getSelectedItem().equals("office")) {
                            ClothesType tshirt = utils.findClothesTypeByName(clothesTypes, "sports T-shirt");
                            ArrayList<ItemOfClothing> tshirts = utils.getItemOfClothingWithType(con, tshirt);
                            ClothesType shorts = utils.findClothesTypeByName(clothesTypes, "sports short");
                            ArrayList<ItemOfClothing> shorts_col = utils.getItemOfClothingWithType(con, shorts);
                            if (tshirts.size() != 0 && shorts_col.size() != 0) {
                                result.add(tshirts.get(0).getItem_producer_name() + " " + tshirt.getType_name());
                                result.add(shorts_col.get(0).getItem_producer_name() + " " + shorts.getType_name());
                            } else {
                                ClothesType tshirt2 = utils.findClothesTypeByName(clothesTypes, "golf");
                                ArrayList<ItemOfClothing> tshirts2 = utils.getItemOfClothingWithType(con, tshirt2);
                                ClothesType shorts2 = utils.findClothesTypeByName(clothesTypes, "formal pants");
                                ArrayList<ItemOfClothing> shorts_col2 = utils.getItemOfClothingWithType(con, shorts2);
                                if (tshirts2.size() != 0 && shorts_col2.size() != 0) {
                                    result.add(tshirts2.get(0).getItem_producer_name() + " " + tshirt2.getType_name());
                                    result.add(shorts_col2.get(0).getItem_producer_name() + " " + shorts2.getType_name());
                                }
                            }
                        }
                        if (location.getSelectedItem().equals("forest")) {
                            if (activity_type.getSelectedItem().equals("not active")) {
                                ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                                ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                                ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                                ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                                if (golfs.size() != 0 && pants.size() != 0) {
                                    result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                    result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                                }
                            }
                            if (activity_type.getSelectedItem().equals("active")) {
                                ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports T-shirt");
                                ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                                ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                                ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                                if (golfs.size() != 0 && pants.size() != 0) {
                                    result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                    result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                                }
                            }
                            if (activity_type.getSelectedItem().equals("very active")) {
                                ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports tank");
                                ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                                ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports short");
                                ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                                if (golfs.size() != 0 && pants.size() != 0) {
                                    result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                    result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                                }
                            }
                        }
                        if (location.getSelectedItem().equals("beach")) {
                            ClothesType cap = utils.findClothesTypeByName(clothesTypes, "cap");
                            ArrayList<ItemOfClothing> caps = utils.getItemOfClothingWithType(con, cap);

                            if (caps.size() != 0)
                                result.add(caps.get(0).getItem_producer_name() + " " + cap.getType_name());

                            if (activity_type.getSelectedItem().equals("not active")) {
                                ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                                ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                                ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                                ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                                if (golfs.size() != 0 && pants.size() != 0) {
                                    result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                    result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                                }
                            }
                            if (activity_type.getSelectedItem().equals("active")) {
                                ClothesType swim_trunk = utils.findClothesTypeByName(clothesTypes, "swim trunk");
                                ArrayList<ItemOfClothing> swim_trunks = utils.getItemOfClothingWithType(con, swim_trunk);

                                if (swim_trunks.size() != 0)
                                    result.add(swim_trunks.get(0).getItem_producer_name() + " " + swim_trunk.getType_name());

                                ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports T-shirt");
                                ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                                ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports short");
                                ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                                if (golfs.size() != 0 && pants.size() != 0) {
                                    result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                    result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                                }
                            }
                            if (activity_type.getSelectedItem().equals("very active")) {
                                ClothesType swim_trunk = utils.findClothesTypeByName(clothesTypes, "swim trunk");
                                ArrayList<ItemOfClothing> swim_trunks = utils.getItemOfClothingWithType(con, swim_trunk);

                                if (swim_trunks.size() != 0)
                                    result.add(swim_trunks.get(0).getItem_producer_name() + " " + swim_trunk.getType_name());

                                ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports tank");
                                ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                                ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports short");
                                ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                                if (golfs.size() != 0 && pants.size() != 0) {
                                    result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                    result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                                }
                            }
                        }
                        if (location.getSelectedItem().equals("theater")) {
                            ClothesType golf = utils.findClothesTypeByName(clothesTypes, "golf");
                            ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "formal pants");
                            ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                            ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, formal_pants);
                            if (golfs.size() != 0 && pants.size() != 0) {
                                result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                            }
                        }
                        if (location.getSelectedItem().equals("gym")) {
                            if (activity_type.getSelectedItem().equals("active")) {
                                ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports T-shirt");
                                ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                                ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports short");
                                ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                                if (golfs.size() != 0 && pants.size() != 0) {
                                    result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                    result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                                }
                            }
                            if (activity_type.getSelectedItem().equals("very active")) {
                                ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports tank");
                                ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                                ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports short");
                                ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                                if (golfs.size() != 0 && pants.size() != 0) {
                                    result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                    result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                                }
                            }
                            if (activity_type.getSelectedItem().equals("not active")) {
                                ClothesType golf = utils.findClothesTypeByName(clothesTypes, "sports hoodie");
                                ArrayList<ItemOfClothing> golfs = utils.getItemOfClothingWithType(con, golf);
                                ClothesType formal_pants = utils.findClothesTypeByName(clothesTypes, "sports pants");
                                ArrayList<ItemOfClothing> pants = utils.getItemOfClothingWithType(con, golf);
                                if (golfs.size() != 0 && pants.size() != 0) {
                                    result.add(golfs.get(0).getItem_producer_name() + " " + golf.getType_name());
                                    result.add(pants.get(0).getItem_producer_name() + " " + formal_pants.getType_name());
                                }
                            }
                        }
                    }
                }
            });

            this.add(get_result);
            this.add(result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    ;

}