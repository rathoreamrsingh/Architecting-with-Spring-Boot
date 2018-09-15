import { NgModule } from '../../node_modules/@angular/core';
import {MatSidenavModule, MatMenuModule, MatIconModule, MatButtonModule,
     MatCardModule, MatDatepickerModule, MatCheckboxModule, MatInputModule, MatNativeDateModule, MatListModule, MatTableModule, MatPaginator, MatPaginatorModule} from '@angular/material';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';

@NgModule({
    imports: [
        MatMenuModule,
        MatCardModule,
        MatButtonModule,
        MatFormFieldModule,
        MatInputModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatCheckboxModule,
        MatSidenavModule,
        MatToolbarModule,
        MatIconModule,
        MatListModule,
        MatTableModule,
        MatPaginatorModule
    ],
    exports: [
        MatMenuModule,
        MatCardModule,
        MatButtonModule,
        MatFormFieldModule,
        MatInputModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatCheckboxModule,
        MatSidenavModule,
        MatToolbarModule,
        MatIconModule,
        MatListModule,
        MatTableModule,
        MatPaginatorModule
    ]
})
export class MaterialModule{}
