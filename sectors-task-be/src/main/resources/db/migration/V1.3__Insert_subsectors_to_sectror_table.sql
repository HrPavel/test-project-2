SELECT *
FROM fill_selectors('Information Technology and Telecommunications',
                    ARRAY[
                     'Data processing, Web portals, E-marketing',
                    'Programming, Consultancy',
                    'Software, Hardware',
                    'Telecommunications']);

SELECT *
FROM fill_selectors('Transport and Logistics',
                    ARRAY[
                    'Air',
                    'Rail',
                    'Road',
                    'Water']);


SELECT *
FROM fill_selectors('Food and Beverage',
                    ARRAY[
                    'Bakery &amp; confectionery products',
                    'Beverages',
                    'Fish & fish products',
                    'Meat & meat products',
                    'Milk & dairy products',
                    'Other (Food and Beverage)',
                    'Sweets & snack food' ]);

SELECT *
FROM fill_selectors('Furniture',
                    ARRAY[
                    'Bathroom/sauna',
                    'Bedroom',
                    'Children’s room',
                    'Kitchen',
                    'Living room',
                    'Office',
                    'Other (Furniture)',
                    'Outdoor',
                    'Project furniture']);

SELECT *
FROM fill_selectors('Machinery',
                    ARRAY[
                    'Machinery components',
                    'Machinery equipment/tools',
                    'Manufacture of machinery',
                    'Maritime',
                    'Metal structures',
                    'Other(Machinery)',
                    'Repair and maintenance service']);

SELECT *
FROM fill_selectors('Maritime',
                    ARRAY[
                    'Aluminium and steel workboats',
                    'Boat/Yacht building',
                    'Ship repair and conversion']);

SELECT *
FROM fill_selectors('Metalworking',
                    ARRAY[
                    'Construction of metal structures',
                    'Houses and buildings',
                    'Metal products',
                    'Metal works']);

SELECT *
FROM fill_selectors('Metal works',
                    ARRAY[
                    'CNC-machining',
                    'Forgings, Fasteners',
                    'Gas, Plasma, Laser cutting',
                    'MIG, TIG, Aluminum welding']);

SELECT *
FROM fill_selectors('Plastic and Rubber',
                    ARRAY[
                    'Packaging',
                    'Plastic goods',
                    'Plastic processing technology',
                    'Plastic profiles']);

SELECT *
FROM fill_selectors('Plastic processing technology',
                    ARRAY[
                    'Blowing',
                    'Moulding',
                    'Plastics welding and processing',
                    'Plastic profiles']);

SELECT *
FROM fill_selectors('Printing',
                    ARRAY[
                    'Advertising',
                    'Book/Periodicals printing',
                    'Labelling and packaging printing']);

SELECT *
FROM fill_selectors('Textile and Clothing',
                    ARRAY[
                    'Clothing',
                    'Textile']);

SELECT *
FROM fill_selectors('Wood',
                    ARRAY[
                    'Other (Wood)',
                    'Wooden building materials',
                    'Wooden houses']);