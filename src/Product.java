import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "image")
public class Product {
    @EqualsAndHashCode.Include
    private long id;
    private String name;
    private LocalDate expirationDate;
    private float price;
    private byte[] image;
}
